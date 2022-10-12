package uz.boom.chatserver.dto.base;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:16 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
public class GenericDTO implements BaseDTO {
    @NotNull(message = "Id cannot be null")
    public Long id;
    @NotNull(message = "CreatedAt cannot be null")
    public Timestamp createdAt;
}
