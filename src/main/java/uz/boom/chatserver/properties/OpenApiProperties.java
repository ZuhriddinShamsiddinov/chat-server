package uz.boom.chatserver.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:38 PM 10/9/22 on Sunday in October
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "api.info")
public class OpenApiProperties {
    private String title;
    private String description;
    private String version;
    private String termsOfCount;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
}
