package mail.services;

import mail.models.InboxMail;
import mail.models.Inbox;

public interface MailServiceConnections {
    
    String URL_INFO = "https://10minutemail.net/address.api.php";
    
    String URL_MORE_100_MINUTES = "https://10minutemail.net/more100.html";
    
    String URL_MORE_10_MINUTES = "https://10minutemail.net/more.html";
    
    String URL_NEW_MAIL = "https://10minutemail.net/new.html";
    
    String URL_RECOVER_MAIL = "https://10minutemail.net/recover.html";
    
    String URL_MAIL_CONTENT = "https://10minutemail.net/mail.api.php?mailid=";
    
    Inbox createNewMailBox() throws Exception;
    
    Inbox recoverEmailBox() throws Exception;
    
    Inbox retrieveDataMailBox() throws Exception;
    
    InboxMail retrieveInboxMail(String mailId) throws Exception;
    
    Inbox reset10Minutes() throws Exception;
    
    Inbox reset100Minutes() throws Exception;
}
