package uz.boom.chatserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:01 PM 10/9/22 on Sunday in October
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ApiErrorResponse {
    private String friendlyMessage;
    private String developerMessage;
    private Map<String, Object> errorFields;
    @Builder.Default
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()));
    private String requestPath;
}