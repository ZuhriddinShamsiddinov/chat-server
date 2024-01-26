package uz.boom.chatserver.dto.base;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:16 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
public class GenericDTO implements BaseDTO {
    public Long id;
    public Timestamp createdAt;
}
