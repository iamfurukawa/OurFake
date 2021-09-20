package security.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MD5.class);
    
    public static String generateHash(String message) {
        LOGGER.info("m=generateHash stage=init message={}", message);
        
        try {
            var m = MessageDigest.getInstance("MD5");
            m.update(message.getBytes(), 0, message.length());
            var hash = new BigInteger(1, m.digest()).toString(16);
            
            LOGGER.info("m=generateHash stage=end hash={}", hash);
            return hash;
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("m=generateHash stage=error message={}", message);
            e.printStackTrace();
        }
        return null;
    }
    
}
