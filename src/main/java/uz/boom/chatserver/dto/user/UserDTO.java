package uz.boom.chatserver.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.chatserver.dto.base.GenericDTO;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:15 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends GenericDTO {
    private String username;
}
