package uz.boom.chatserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.boom.chatserver.controllers.base.GenericController;
import uz.boom.chatserver.dto.user.UserCreateDTO;
import uz.boom.chatserver.dto.user.UserDTO;
import uz.boom.chatserver.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:25 PM 10/9/22 on Sunday in October
 */
@RestController
public class UserController extends GenericController<UserService> {
    public UserController(UserService service) {
        super(service);
    }

    @PostMapping(value = PATH + "/users/add", produces = "application/json")
    public ResponseEntity<Long> create(@RequestBody @Valid UserCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping(value = PATH + "/users/list", produces = "application/json")
    public ResponseEntity<List<UserDTO>> getAll() {
        return service.getAll();
    }
}
