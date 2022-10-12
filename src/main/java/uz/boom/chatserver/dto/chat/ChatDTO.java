package uz.boom.chatserver.dto.chat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.chatserver.dto.base.GenericDTO;
import uz.boom.chatserver.dto.user.UserDTO;

import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:20 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatDTO extends GenericDTO {
    private String name;
    private List<UserDTO> users;
}
