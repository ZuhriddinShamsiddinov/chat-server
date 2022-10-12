package uz.boom.chatserver.dto.user;

import lombok.*;
import uz.boom.chatserver.dto.base.BaseDTO;

import javax.validation.constraints.NotBlank;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:19 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDTO implements BaseDTO {
    @NotBlank(message = "Username cannot be blank")
    private String username;
}
