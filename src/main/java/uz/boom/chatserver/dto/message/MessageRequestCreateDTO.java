package uz.boom.chatserver.dto.message;

import lombok.*;
import uz.boom.chatserver.dto.base.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:53 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestCreateDTO implements BaseDTO {
    @NotNull(message = "Chat cannot be null")
    private Long chat;
    @NotNull(message = "Author cannot be null")
    private Long author;
    @NotBlank(message = "Type cannot be blank")
    private String type;
    @NotBlank(message = "Context cannot be blank")
    private String content;
    @NotBlank(message = "Extension cannot be blank")
    private String ext;
}
