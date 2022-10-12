package uz.boom.chatserver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.boom.chatserver.domains.Message;
import uz.boom.chatserver.dto.message.MessageCreateDTO;
import uz.boom.chatserver.dto.message.MessageDTO;
import uz.boom.chatserver.dto.message.MessageRequestCreateDTO;
import uz.boom.chatserver.enums.MessageType;
import uz.boom.chatserver.exceptions.BadRequestException;
import uz.boom.chatserver.mappers.MessageMapper;
import uz.boom.chatserver.repository.MessageRepository;
import uz.boom.chatserver.service.base.GenericService;
import uz.boom.chatserver.utils.FileUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:04 PM 10/9/22 on Sunday in October
 */
@Service
@CacheConfig(cacheNames = "message-cache")
@Slf4j
public class MessageService extends GenericService<MessageRepository, MessageMapper> {

    private final ChatService chatService;
    private final UserService userService;
    private final FileUtils fileUtils;

    public MessageService(MessageRepository repository, MessageMapper mapper, ChatService chatService, UserService userService, FileUtils fileUtils) {
        super(repository, mapper);
        this.chatService = chatService;
        this.userService = userService;
        this.fileUtils = fileUtils;
    }


    @CacheEvict(cacheNames = "messages", allEntries = true)
    public ResponseEntity<Long> create(MessageRequestCreateDTO dto) {
        MessageCreateDTO createDTO = MessageCreateDTO
                .builder()
                .chat(chatService.getById(dto.getChat()))
                .author(userService.getById(dto.getAuthor()))
                .content(dto.getContent())
                .build();
        switch (dto.getType()) {
            case "text" -> createDTO.setMessageType(MessageType.TEXT);
            case "image" -> {
                createDTO.setMessageType(MessageType.IMAGE);
                Runnable runnable = () -> {
                    fileUtils.createFile(dto);
                };
                runnable.run();
            }
            default -> throw new BadRequestException("Message type is invalid");
        }
        Message message = mapper.fromCreateDTO(createDTO);
        repository.save(message);
        log.info("Create Message by '{}'", createDTO);
        return new ResponseEntity<>(message.getId(), HttpStatus.OK);
    }


    public ResponseEntity<List<MessageDTO>> getAll(Long chatId) {
        List<Message> messageList = repository.findAllByChat(chatService.getEntityById(chatId));
        messageList.sort(Collections.reverseOrder());
        List<MessageDTO> messageDTOList = mapper.toDTO(messageList);
        log.info("Get all Messages method called");
        return new ResponseEntity<>(messageDTOList, HttpStatus.OK);
    }


}
