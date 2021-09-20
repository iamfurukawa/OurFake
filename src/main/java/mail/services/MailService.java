package mail.services;

import com.google.gson.Gson;
import mail.models.InboxMail;
import mail.models.Inbox;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.CookieManager;
import java.net.CookiePolicy;

public class MailService implements MailServiceConnections {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);
    
    // Use for reference: https://github.com/Zaczero/10MinuteMail.net/blob/a8a0e320cdc31ede6da19e8c95b37d3bd77d445d/10MinuteMail.net/TenMinuteMail.cs#L32
    private final OkHttpClient client;
    
    private final Gson gson = new Gson();
    
    public MailService() {
        LOGGER.info("m=MailService stage=init starting a mail service");
        var cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();
        
        LOGGER.info("m=MailService stage=end");
    }
    
    public Inbox createNewMailBox() throws Exception {
        LOGGER.info("m=createNewMailBox stage=init starting a mail service");
        var request = new Request.Builder()
                .url(URL_NEW_MAIL)
                .get()
                .build();
    
        client.newCall(request).execute();
        LOGGER.info("m=createNewMailBox stage=end");
        return reset100Minutes();
    }
    
    public Inbox recoverEmailBox() throws Exception {
        LOGGER.info("m=recoverEmailBox stage=init starting a mail service");
        var request = new Request.Builder()
                .url(URL_RECOVER_MAIL)
                .get()
                .build();
        
        client.newCall(request).execute();
        LOGGER.info("m=recoverEmailBox stage=end");
        return reset100Minutes();
    }
    
    public Inbox retrieveDataMailBox() throws Exception {
        LOGGER.info("m=retrieveDataMailBox stage=init starting a mail service");
        var request = new Request.Builder()
                .url(URL_INFO)
                .get()
                .build();
    
        var response = client.newCall(request).execute();
        try {
            var inbox = gson.fromJson(response.body().string(), Inbox.class);
            LOGGER.info("m=retrieveDataMailBox stage=end");
            return inbox;
        } catch (Exception e) {
            LOGGER.info("m=retrieveDataMailBox stage=error stacktrace={}", e.getStackTrace());
            throw e;
        }
    }
    
    public InboxMail retrieveInboxMail(String mailId) throws Exception {
        LOGGER.info("m=retrieveInboxMail stage=init starting a mail service");
        var request = new Request.Builder()
                .url(URL_MAIL_CONTENT + mailId)
                .get()
                .build();
        
        var response = client.newCall(request).execute();
        try {
            var inboxMail = gson.fromJson(response.body().string(), InboxMail.class);
            LOGGER.info("m=retrieveInboxMail stage=end");
            return inboxMail;
        } catch (Exception e) {
            LOGGER.info("m=retrieveInboxMail stage=error stacktrace={}", e.getStackTrace());
            throw e;
        }
    }
    
    public Inbox reset10Minutes() throws Exception {
        LOGGER.info("m=reset10Minutes stage=init starting a mail service");
        var request = new Request.Builder()
                .url(URL_MORE_10_MINUTES)
                .get()
                .build();
    
        client.newCall(request).execute();
        LOGGER.info("m=reset10Minutes stage=end");
        return retrieveDataMailBox();
    }
    
    public Inbox reset100Minutes() throws Exception {
        LOGGER.info("m=reset100Minutes stage=init starting a mail service");
        var request = new Request.Builder()
                .url(URL_MORE_100_MINUTES)
                .get()
                .build();
        
        client.newCall(request).execute();
        LOGGER.info("m=reset100Minutes stage=end");
        return retrieveDataMailBox();
    }
   
}
