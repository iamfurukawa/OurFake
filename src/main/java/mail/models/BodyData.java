package mail.models;

import com.google.gson.annotations.SerializedName;

public class BodyData {
    
    private String content;
    
    private String charset;
    
    @SerializedName("bodylength")
    private int bodyLength;
    
    private String body;
    
    public String getContent() {
        return content;
    }
    
    public BodyData setContent(String content) {
        this.content = content;
        return this;
    }
    
    public String getCharset() {
        return charset;
    }
    
    public BodyData setCharset(String charset) {
        this.charset = charset;
        return this;
    }
    
    public int getBodyLength() {
        return bodyLength;
    }
    
    public BodyData setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
        return this;
    }
    
    public String getBody() {
        return body;
    }
    
    public BodyData setBody(String body) {
        this.body = body;
        return this;
    }
    
}
