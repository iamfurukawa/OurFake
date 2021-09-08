package mail.services;

import com.google.gson.Gson;
import mail.models.Email;
import mail.models.Inbox;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;

public class MailService implements MailServiceConnections {
    // Use for reference: https://github.com/Zaczero/10MinuteMail.net/blob/a8a0e320cdc31ede6da19e8c95b37d3bd77d445d/10MinuteMail.net/TenMinuteMail.cs#L32
    private OkHttpClient client;
    
    private final Gson gson = new Gson();
    
    public MailService() {
        var cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    
        client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();
    }
    
    public Inbox createNewMailBox() throws IOException {
        var request = new Request.Builder()
                .url(URL_NEW_MAIL)
                .get()
                .build();
    
        client.newCall(request)
                .execute();
        return reset100Minutes();
    }
    
    public Inbox recoverEmailBox() throws IOException {
        var request = new Request.Builder()
                .url(URL_RECOVER_MAIL)
                .get()
                .build();
        
        client.newCall(request)
            .execute();
        return reset100Minutes();
    }
    
    public Inbox retrieveDataMailBox() throws IOException {
        var request = new Request.Builder()
                .url(URL_INFO)
                .get()
                .build();
    
        var response = client.newCall(request)
                .execute();
        return gson.fromJson(response.body().string(), Inbox.class);
    }
    
    public Email retrieveInboxMail(String mailId) throws IOException {
        var request = new Request.Builder()
                .url(URL_MAIL_CONTENT + mailId)
                .get()
                .build();
        
        var response = client.newCall(request)
                .execute();
        return gson.fromJson(response.body().string(), Email.class);
    }
    
    public Inbox reset10Minutes() throws IOException {
        var request = new Request.Builder()
                .url(URL_MORE_10_MINUTES)
                .get()
                .build();
    
        client.newCall(request)
                .execute();
        return retrieveDataMailBox();
    }
    
    public Inbox reset100Minutes() throws IOException {
        var request = new Request.Builder()
                .url(URL_MORE_100_MINUTES)
                .get()
                .build();
        
        client.newCall(request)
                .execute();
        return retrieveDataMailBox();
    }
   
}
