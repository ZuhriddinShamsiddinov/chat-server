package uz.boom.chatserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.chatserver.domains.Message;
import uz.boom.chatserver.dto.message.MessageCreateDTO;
import uz.boom.chatserver.dto.message.MessageDTO;
import uz.boom.chatserver.mappers.base.BaseMapper;

import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:32 PM 10/9/22 on Sunday in October
 */
//@Component
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
        uses = {UserMapper.class, ChatMapper.class})
public interface MessageMapper extends BaseMapper {


    List<MessageDTO> toDTO(List<Message> entities);


    Message fromCreateDTO(MessageCreateDTO dto);
}



