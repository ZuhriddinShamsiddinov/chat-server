package uz.boom.chatserver.dto.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.chatserver.dto.base.GenericDTO;
import uz.boom.chatserver.dto.user.UserDTO;
import uz.boom.chatserver.enums.MessageType;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:26 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO extends GenericDTO {
    private Long chatId;
    private UserDTO author;
    private MessageType contentType;
    private String content;
}
