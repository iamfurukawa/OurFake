package mail.models;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

public class InboxMail {
    
    private String from;
    
    private String gravatar;
    
    private String to;
    
    private String subject;
    
    private String datetime;
    
    private float timestamp;
    
    private String datetime2;
    
    private List<String> urls;
    
    private List<BodyData> body;
    
    private List<Object> attachment; //not defined!
    
    @SerializedName("header_decode")
    private HeaderData headerData;
    
    private String plain;
    
    @SerializedName("plain_link")
    private String plainLink;
    
    @SerializedName("raw_html")
    private List<String> rawHtml;
    
    private List<String> html;
    
    @SerializedName("html_to_plain")
    private List<String> htmlToPlain;
    
    public String getFrom() {
        return from;
    }
    
    public InboxMail setFrom(String from) {
        this.from = from;
        return this;
    }
    
    public String getGravatar() {
        return gravatar;
    }
    
    public InboxMail setGravatar(String gravatar) {
        this.gravatar = gravatar;
        return this;
    }
    
    public String getTo() {
        return to;
    }
    
    public InboxMail setTo(String to) {
        this.to = to;
        return this;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public InboxMail setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    
    public String getDatetime() {
        return datetime;
    }
    
    public InboxMail setDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }
    
    public float getTimestamp() {
        return timestamp;
    }
    
    public InboxMail setTimestamp(float timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    
    public String getDatetime2() {
        return datetime2;
    }
    
    public InboxMail setDatetime2(String datetime2) {
        this.datetime2 = datetime2;
        return this;
    }
    
    public List<String> getUrls() {
        return urls;
    }
    
    public InboxMail setUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }
    
    public List<BodyData> getBody() {
        return body;
    }
    
    public InboxMail setBody(List<BodyData> body) {
        this.body = body;
        return this;
    }
    
    public List<Object> getAttachment() {
        return attachment;
    }
    
    public InboxMail setAttachment(List<Object> attachment) {
        this.attachment = attachment;
        return this;
    }
    
    public HeaderData getHeaderData() {
        return headerData;
    }
    
    public InboxMail setHeaderData(HeaderData headerData) {
        this.headerData = headerData;
        return this;
    }
    
    public String getPlain() {
        return plain;
    }
    
    public InboxMail setPlain(String plain) {
        this.plain = plain;
        return this;
    }
    
    public String getPlainLink() {
        return plainLink;
    }
    
    public InboxMail setPlainLink(String plainLink) {
        this.plainLink = plainLink;
        return this;
    }
    
    public List<String> getRawHtml() {
        return rawHtml;
    }
    
    public InboxMail setRawHtml(List<String> rawHtml) {
        this.rawHtml = rawHtml;
        return this;
    }
    
    public List<String> getHtml() {
        return html;
    }
    
    public InboxMail setHtml(List<String> html) {
        this.html = html;
        return this;
    }
    
    public List<String> getHtmlToPlain() {
        return htmlToPlain;
    }
    
    public InboxMail setHtmlToPlain(List<String> htmlToPlain) {
        this.htmlToPlain = htmlToPlain;
        return this;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
