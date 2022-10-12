package uz.boom.chatserver.dto.message;

import lombok.*;
import uz.boom.chatserver.dto.base.BaseDTO;
import uz.boom.chatserver.dto.chat.ChatDTO;
import uz.boom.chatserver.dto.user.UserDTO;
import uz.boom.chatserver.enums.MessageType;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:27 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageCreateDTO implements BaseDTO {
    private ChatDTO chat;
    private UserDTO author;
    private MessageType messageType;
    private String content;
}
