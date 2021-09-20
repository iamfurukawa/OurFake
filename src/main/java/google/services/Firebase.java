package google.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Firebase {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Firebase.class);
    
    public static final String REALTIME_DATABASE_URL = "https://oursms-c7296-default-rtdb.firebaseio.com";
    
    public static final String SERVICE_ACCOUNT_FILE = "serviceAccount.json";
    
    private FirebaseApp app;
    
    public Firebase() {
        LOGGER.info("m=Firebase stage=init");
        try {
            var classloader = Thread.currentThread().getContextClassLoader();
            var file = new File(classloader.getResource(SERVICE_ACCOUNT_FILE).getFile());
            var serviceAccount = new FileInputStream(file);
            
            var options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(REALTIME_DATABASE_URL)
                    .build();
            app = FirebaseApp.initializeApp(options);
            
        } catch (IOException e) {
            LOGGER.error("m=Firebase stage=error stacktrace={}" + e.getStackTrace());
            System.exit(0);
        }
        LOGGER.info("m=Firebase stage=end");
    }
    
    public FirebaseApp getApp() {
        return app;
    }
    
}
