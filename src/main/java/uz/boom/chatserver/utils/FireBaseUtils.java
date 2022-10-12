package uz.boom.chatserver.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:06 PM 10/9/22 on Sunday in October
 */
@Component
public class FireBaseUtils {
    private Storage storage;

    public String upload(MultipartFile file) throws IOException {
        String newFilename = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());
        BlobId blobId = BlobId.of("zuhriddin-project.appspot.com", newFilename);

        Map<String, String> metaData = new HashMap<>();
        metaData.put("originalName", file.getOriginalFilename());
        metaData.put("contentType", file.getContentType());
        metaData.put("size", "" + file.getSize());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(file.getContentType())
                .setMetadata(metaData)
                .build();
        storage.create(blobInfo, file.getInputStream().readAllBytes());
        return newFilename;
    }


    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable String filename) {
        BlobId blobId = BlobId.of("zuhriddin-project.appspot.com", filename);

        Blob blob = storage.get(blobId);
        Map<String, String> metadata = blob.getMetadata();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = " + metadata.get("originalName"))
                .contentLength(Long.parseLong(metadata.get("size")))
                .contentType(MediaType.parseMediaType(metadata.get("contentType")))
                .body(blob.getContent());
    }


    @EventListener
    public void init(ApplicationReadyEvent applicationReadyEvent) {
        try {
            InputStream serviceAccount = new FileInputStream("src/main/resources/zuhriddin-project-firebase-adminsdk-pmzi6-70fed374e6.json");
            storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("zuhriddin-project")
                    .build().getService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
