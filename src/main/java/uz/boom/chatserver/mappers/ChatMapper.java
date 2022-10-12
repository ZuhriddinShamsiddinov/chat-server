package uz.boom.chatserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.chatserver.domains.Chat;
import uz.boom.chatserver.dto.chat.ChatCreateDTO;
import uz.boom.chatserver.dto.chat.ChatDTO;
import uz.boom.chatserver.mappers.base.BaseMapper;

import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:23 PM 10/9/22 on Sunday in October
 */
//@Component
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
        uses = {UserMapper.class}
)
public interface ChatMapper extends BaseMapper {


    ChatDTO toDTO(Chat chat);


    List<ChatDTO> toDTO(List<Chat> chatList);


    Chat fromCreateDTO(ChatCreateDTO dto);
}
