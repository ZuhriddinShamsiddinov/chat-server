package uz.boom.chatserver.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.boom.chatserver.domains.User;
import uz.boom.chatserver.dto.user.UserCreateDTO;
import uz.boom.chatserver.dto.user.UserDTO;
import uz.boom.chatserver.exceptions.NotFoundException;
import uz.boom.chatserver.mappers.UserMapper;
import uz.boom.chatserver.repository.UserRepository;
import uz.boom.chatserver.service.base.GenericService;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:33 PM 10/9/22 on Sunday in October
 */
@Service
@CacheConfig(cacheNames = "user-cache")
@Slf4j
public class UserService extends GenericService<UserRepository, UserMapper> {

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @CacheEvict(key = "#dto.username")
    public ResponseEntity<Long> create(UserCreateDTO dto) {
        User user = mapper.fromCreateDTO(dto);
        repository.save(user);
        log.info("User created by '{}'", dto);
        return new ResponseEntity<>(user.getId(), HttpStatus.OK);
    }


    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> userList = repository.findAll();
        userList.sort(Collections.reverseOrder());
        List<UserDTO> userDTOList = mapper.toDTO(userList);
        log.info("Get All Users method called");
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @Cacheable(cacheNames = "users")
    public List<UserDTO> getAllByIds(List<Long> listId) {
        Optional<List<User>> optional = repository.findAllByIds(listId);
        return optional.map(mapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Any user not found"));
    }

    public UserDTO getById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        log.info("Get one User by id '{}'", id);
        return mapper.toDTO(user);
    }
}
