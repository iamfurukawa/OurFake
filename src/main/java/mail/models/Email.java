package mail.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Email {
    
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
    
    public Email setFrom(String from) {
        this.from = from;
        return this;
    }
    
    public String getGravatar() {
        return gravatar;
    }
    
    public Email setGravatar(String gravatar) {
        this.gravatar = gravatar;
        return this;
    }
    
    public String getTo() {
        return to;
    }
    
    public Email setTo(String to) {
        this.to = to;
        return this;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    
    public String getDatetime() {
        return datetime;
    }
    
    public Email setDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }
    
    public float getTimestamp() {
        return timestamp;
    }
    
    public Email setTimestamp(float timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    
    public String getDatetime2() {
        return datetime2;
    }
    
    public Email setDatetime2(String datetime2) {
        this.datetime2 = datetime2;
        return this;
    }
    
    public List<String> getUrls() {
        return urls;
    }
    
    public Email setUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }
    
    public List<BodyData> getBody() {
        return body;
    }
    
    public Email setBody(List<BodyData> body) {
        this.body = body;
        return this;
    }
    
    public List<Object> getAttachment() {
        return attachment;
    }
    
    public Email setAttachment(List<Object> attachment) {
        this.attachment = attachment;
        return this;
    }
    
    public HeaderData getHeaderData() {
        return headerData;
    }
    
    public Email setHeaderData(HeaderData headerData) {
        this.headerData = headerData;
        return this;
    }
    
    public String getPlain() {
        return plain;
    }
    
    public Email setPlain(String plain) {
        this.plain = plain;
        return this;
    }
    
    public String getPlainLink() {
        return plainLink;
    }
    
    public Email setPlainLink(String plainLink) {
        this.plainLink = plainLink;
        return this;
    }
    
    public List<String> getRawHtml() {
        return rawHtml;
    }
    
    public Email setRawHtml(List<String> rawHtml) {
        this.rawHtml = rawHtml;
        return this;
    }
    
    public List<String> getHtml() {
        return html;
    }
    
    public Email setHtml(List<String> html) {
        this.html = html;
        return this;
    }
    
    public List<String> getHtmlToPlain() {
        return htmlToPlain;
    }
    
    public Email setHtmlToPlain(List<String> htmlToPlain) {
        this.htmlToPlain = htmlToPlain;
        return this;
    }
    
}
