package uz.boom.chatserver.dto.chat;

import lombok.*;
import uz.boom.chatserver.dto.base.BaseDTO;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:53 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestCreateDTO implements BaseDTO {
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private List<Long> users;
}
