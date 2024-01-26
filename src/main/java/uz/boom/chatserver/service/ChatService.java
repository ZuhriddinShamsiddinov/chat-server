package uz.boom.chatserver.service;

import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.boom.chatserver.domains.Chat;
import uz.boom.chatserver.dto.chat.ChatCreateDTO;
import uz.boom.chatserver.dto.chat.ChatDTO;
import uz.boom.chatserver.dto.chat.ChatRequestCreateDTO;
import uz.boom.chatserver.exceptions.NotFoundException;
import uz.boom.chatserver.mappers.ChatMapper;
import uz.boom.chatserver.repository.ChatRepository;
import uz.boom.chatserver.service.base.GenericService;


/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:47 PM 10/9/22 on Sunday in October
 */
@Service
@CacheConfig(cacheNames = "chat-cache")
@Slf4j
public class ChatService extends GenericService<ChatRepository, ChatMapper> {

    private final UserService userService;

    public ChatService(ChatRepository repository, ChatMapper mapper, UserService userService) {
        super(repository, mapper);
        this.userService = userService;
    }


    @CacheEvict(cacheNames = "chats", allEntries = true)
    public ResponseEntity<Long> create(ChatRequestCreateDTO dto) {
        ChatCreateDTO createDTO = ChatCreateDTO
                .builder()
                .name(dto.getName())
                .users(userService.getAllByIds(dto.getUsers()))
                .build();
        Chat chat = mapper.fromCreateDTO(createDTO);
        repository.save(chat);
        log.info("Chat create by {}", dto);
        return new ResponseEntity<>(chat.getId(), HttpStatus.OK);
    }


    public ResponseEntity<List<ChatDTO>> getAll(Long userId) {
        List<Chat> chatList = repository.findAllByUserId(userId);
        Collections.sort(chatList, Collections.reverseOrder());
        List<ChatDTO> chatDTOList = mapper.toDTO(chatList);
        log.info("Chat getAll method called");
        return new ResponseEntity<>(chatDTOList, HttpStatus.OK);
    }

    @Cacheable(cacheNames = "chats", key = "#id", unless = "#result==null")
    public Chat getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Chat not found"));
    }

    public ChatDTO getById(Long id) {
        Chat chat = repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Chat not found"));
        log.info("Chat getOne by id '{}'", id);
        return mapper.toDTO(chat);
    }


}
