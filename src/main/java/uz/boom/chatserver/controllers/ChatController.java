package uz.boom.chatserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.boom.chatserver.controllers.base.GenericController;
import uz.boom.chatserver.dto.chat.ChatDTO;
import uz.boom.chatserver.dto.chat.ChatGetByUserDTO;
import uz.boom.chatserver.dto.chat.ChatRequestCreateDTO;
import uz.boom.chatserver.service.ChatService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:29 PM 10/9/22 on Sunday in October
 */
@RestController
public class ChatController extends GenericController<ChatService> {
    public ChatController(ChatService service) {
        super(service);
    }

    @PostMapping(value = PATH + "/chats/add", produces = "application/json")
    public ResponseEntity<Long> create(@RequestBody @Valid ChatRequestCreateDTO dto) {
        return service.create(dto);
    }

    @PostMapping(value = PATH + "/chats/get", produces = "application/json")
    public ResponseEntity<List<ChatDTO>> getAll(@RequestBody ChatGetByUserDTO dto) {
        return service.getAll(dto.getUser());
    }
}
