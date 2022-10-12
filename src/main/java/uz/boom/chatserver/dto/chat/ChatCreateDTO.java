package uz.boom.chatserver.dto.chat;

import lombok.*;
import uz.boom.chatserver.dto.base.BaseDTO;
import uz.boom.chatserver.dto.user.UserDTO;

import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:20 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatCreateDTO implements BaseDTO {
    private String name;
    private List<UserDTO> users;
}
