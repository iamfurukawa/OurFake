package mail.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inbox {
    
    @SerializedName("mail_get_user")
    private String mailGetUser;
    
    @SerializedName("mail_get_mail")
    private String mailGetMail;
    
    @SerializedName("mail_get_host")
    private String mailGetHost;
    
    @SerializedName("mail_get_time")
    private double mailGetTime;
    
    @SerializedName("mail_get_duetime")
    private double mailGetDuetime;
    
    @SerializedName("mail_server_time")
    private double mailServerTime;
    
    @SerializedName("mail_get_key")
    private String mailGetKey;
    
    @SerializedName("mail_left_time")
    private double mailLeftTime;
    
    @SerializedName("mail_recovering_key")
    private String mailRecoveringKey = null;
    
    @SerializedName("mail_recovering_mail")
    private String mailRecoveringMail = null;
    
    @SerializedName("session_id")
    private String sessionId;
    
    @SerializedName("permalink")
    private Permalink permalink;
    
    @SerializedName("mail_list")
    private List<InboxItem> mailList;
    
    public String getMailGetUser() {
        return mailGetUser;
    }
    
    public Inbox setMailGetUser(String mailGetUser) {
        this.mailGetUser = mailGetUser;
        return this;
    }
    
    public String getMailGetMail() {
        return mailGetMail;
    }
    
    public Inbox setMailGetMail(String mailGetMail) {
        this.mailGetMail = mailGetMail;
        return this;
    }
    
    public String getMailGetHost() {
        return mailGetHost;
    }
    
    public Inbox setMailGetHost(String mailGetHost) {
        this.mailGetHost = mailGetHost;
        return this;
    }
    
    public double getMailGetTime() {
        return mailGetTime;
    }
    
    public Inbox setMailGetTime(double mailGetTime) {
        this.mailGetTime = mailGetTime;
        return this;
    }
    
    public double getMailGetDuetime() {
        return mailGetDuetime;
    }
    
    public Inbox setMailGetDuetime(double mailGetDuetime) {
        this.mailGetDuetime = mailGetDuetime;
        return this;
    }
    
    public double getMailServerTime() {
        return mailServerTime;
    }
    
    public Inbox setMailServerTime(double mailServerTime) {
        this.mailServerTime = mailServerTime;
        return this;
    }
    
    public String getMailGetKey() {
        return mailGetKey;
    }
    
    public Inbox setMailGetKey(String mailGetKey) {
        this.mailGetKey = mailGetKey;
        return this;
    }
    
    public double getMailLeftTime() {
        return mailLeftTime;
    }
    
    public Inbox setMailLeftTime(double mailLeftTime) {
        this.mailLeftTime = mailLeftTime;
        return this;
    }
    
    public String getMailRecoveringKey() {
        return mailRecoveringKey;
    }
    
    public Inbox setMailRecoveringKey(String mailRecoveringKey) {
        this.mailRecoveringKey = mailRecoveringKey;
        return this;
    }
    
    public String getMailRecoveringMail() {
        return mailRecoveringMail;
    }
    
    public Inbox setMailRecoveringMail(String mailRecoveringMail) {
        this.mailRecoveringMail = mailRecoveringMail;
        return this;
    }
    
    public String getSessionId() {
        return sessionId;
    }
    
    public Inbox setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }
    
    public Permalink getPermalink() {
        return permalink;
    }
    
    public Inbox setPermalink(Permalink permalink) {
        this.permalink = permalink;
        return this;
    }
    
    public List<InboxItem> getMailList() {
        return mailList;
    }
    
    public Inbox setMailList(ArrayList<InboxItem> mailList) {
        this.mailList = mailList;
        return this;
    }
    
    @Override
    public String toString() {
        return "MailInfoResponse{" + "mailGetUser='" + mailGetUser + '\'' + ", mailGetMail='" + mailGetMail + '\''
                + ", mailGetHost='" + mailGetHost + '\'' + ", mailGetTime=" + mailGetTime + ", mailGetDuetime="
                + mailGetDuetime + ", mailServerTime=" + mailServerTime + ", mailGetKey='" + mailGetKey + '\''
                + ", mailLeftTime=" + mailLeftTime + ", mailRecoveringKey='" + mailRecoveringKey + '\''
                + ", mailRecoveringMail='" + mailRecoveringMail + '\'' + ", sessionId='" + sessionId + '\''
                + ", permalink=" + permalink.toString() + ", mailList="
                + mailList.stream().map(permalinkResponse -> permalinkResponse.toString()).collect(Collectors.joining())
                + '}';
    }
    
}
