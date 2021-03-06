package google.services;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sms.models.SMSMessage;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

import static security.services.MD5.generateHash;

public class RealtimeDatabase extends Firebase {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RealtimeDatabase.class);
    
    final DatabaseReference reference;
    
    private SMSMessage lastRead = null;
    
    public RealtimeDatabase(final String phoneNumber) {
        LOGGER.debug("m=RealtimeDatabase stage=init phoneNumber={}", phoneNumber);
        reference = FirebaseDatabase.getInstance()
                .getReference("/")
                .child(generateHash(phoneNumber));
        LOGGER.debug("m=RealtimeDatabase stage=end");
    }
    
    public void createOrUpdate(final SMSMessage message) {
        LOGGER.debug("m=createOrUpdate stage=init data={}", message);
        
        try {
            reference.updateChildrenAsync(message.toMap()).get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("m=createOrUpdate stage=error stacktrace={}", e.getStackTrace());
        }
        
        LOGGER.debug("m=createOrUpdate stage=end");
    }
    
    public SMSMessage retrieve() throws InterruptedException {
        LOGGER.debug("m=retrieve stage=init");
        Semaphore semaphore = new Semaphore(0);
        
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                LOGGER.debug("m=onDataChange stage=init data={}", dataSnapshot.getValue());
    
                lastRead = dataSnapshot.getValue(SMSMessage.class);
                LOGGER.debug("m=onDataChange stage=end data={}", lastRead.getMessage());
                semaphore.release();
            }
        
            @Override
            public void onCancelled(DatabaseError databaseError) {
                LOGGER.debug("m=retrieve stage=onCancelled error={}", databaseError.getMessage());
            }
        });
        
        semaphore.acquire();
        LOGGER.debug("m=retrieve stage=end");
        return lastRead;
    }
}
