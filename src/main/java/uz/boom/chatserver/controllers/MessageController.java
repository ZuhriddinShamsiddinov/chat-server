package uz.boom.chatserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.boom.chatserver.controllers.base.GenericController;
import uz.boom.chatserver.dto.message.MessageDTO;
import uz.boom.chatserver.dto.message.MessageRequestCreateDTO;
import uz.boom.chatserver.service.MessageService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:31 PM 10/9/22 on Sunday in October
 */
@RestController
public class MessageController extends GenericController<MessageService> {
    public MessageController(MessageService service) {
        super(service);
    }

    @PostMapping(value = PATH + "/messages/add",produces = "application/json")
    public ResponseEntity<Long> create(@RequestBody@Valid MessageRequestCreateDTO dto) {
        return service.create(dto);
    }

    @PostMapping(value = PATH + "/messages/get",produces = "application/json")
    public ResponseEntity<List<MessageDTO>> getAll(@RequestBody Long chatId) {
        return service.getAll(chatId);
    }

}
