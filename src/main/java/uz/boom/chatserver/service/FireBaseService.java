package uz.boom.chatserver.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.chatserver.service.base.BaseService;
import uz.boom.chatserver.utils.FireBaseUtils;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:22 PM 10/9/22 on Sunday in October
 */
@Service
@RequiredArgsConstructor
public class FireBaseService implements BaseService {
    private final FireBaseUtils fireBaseUtils;

    @SneakyThrows
    public String uploadFile(MultipartFile file) {
        return fireBaseUtils.upload(file);
    }

    @SneakyThrows
    public ResponseEntity<byte[]> downloadFile(String filename) {
        return fireBaseUtils.download(filename);
    }

}
