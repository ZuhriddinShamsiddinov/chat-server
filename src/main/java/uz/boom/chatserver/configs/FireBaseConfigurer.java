package uz.boom.chatserver.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 3:09 PM 10/9/22 on Sunday in October
 */
@Component
public class FireBaseConfigurer {
    /**
     * For check uploaded files to Firebase
     * '<a href="https://console.firebase.google.com/project/zuhriddin-project/storage/zuhriddin-project.appspot.com/files">...</a>'
     */
    @PostConstruct
    public void init() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream
                            ("src/main/resources/zuhriddin-project-firebase-adminsdk-pmzi6-70fed374e6.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
