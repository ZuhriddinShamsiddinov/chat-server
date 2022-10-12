package uz.boom.chatserver.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.chatserver.dto.base.BaseDTO;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 10:13 AM 10/12/22 on Wednesday in October
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatGetByUserDTO implements BaseDTO {
    private Long user;
}
