package mail.models;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class InboxItem {
    
    @SerializedName("mail_id")
    private String emailId;
    
    private String from;
    
    private String subject;
    
    private String datetime;
    
    private String datetime2;
    
    @SerializedName("timeago")
    private int timeAgo;
    
    @SerializedName("isread")
    private boolean read;
    
    public String getEmailId() {
        return emailId;
    }
    
    public InboxItem setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }
    
    public String getFrom() {
        return from;
    }
    
    public InboxItem setFrom(String from) {
        this.from = from;
        return this;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public InboxItem setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    
    public String getDatetime() {
        return datetime;
    }
    
    public InboxItem setDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }
    
    public String getDatetime2() {
        return datetime2;
    }
    
    public InboxItem setDatetime2(String datetime2) {
        this.datetime2 = datetime2;
        return this;
    }
    
    public int getTimeAgo() {
        return timeAgo;
    }
    
    public InboxItem setTimeAgo(int timeAgo) {
        this.timeAgo = timeAgo;
        return this;
    }
    
    public boolean isRead() {
        return read;
    }
    
    public InboxItem setRead(boolean read) {
        this.read = read;
        return this;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
