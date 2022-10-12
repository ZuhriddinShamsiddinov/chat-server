package uz.boom.chatserver.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.boom.chatserver.controllers.base.GenericController;
import uz.boom.chatserver.service.FireBaseService;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:56 PM 10/9/22 on Sunday in October
 */
@RestController
public class FireBaseController extends GenericController<FireBaseService> {

    public FireBaseController(FireBaseService service) {
        super(service);
    }

    @PostMapping(value = PATH+"/file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> upload(@RequestParam MultipartFile file) {
        return ResponseEntity.ok()
                .body(service.uploadFile(file));
    }

    @GetMapping(value = PATH+"/file/download/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename) {
        return service.downloadFile(filename);
    }
}
