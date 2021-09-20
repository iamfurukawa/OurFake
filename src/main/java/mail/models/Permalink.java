package mail.models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Permalink {
    
    private String host;
    
    private String mail;
    
    private String url;
    
    private String key;
    
    private double time;
    
    public String getHost() {
        return host;
    }
    
    public Permalink setHost(String host) {
        this.host = host;
        return this;
    }
    
    public String getMail() {
        return mail;
    }
    
    public Permalink setMail(String mail) {
        this.mail = mail;
        return this;
    }
    
    public String getUrl() {
        return url;
    }
    
    public Permalink setUrl(String url) {
        this.url = url;
        return this;
    }
    
    public String getKey() {
        return key;
    }
    
    public Permalink setKey(String key) {
        this.key = key;
        return this;
    }
    
    public double getTime() {
        return time;
    }
    
    public Permalink setTime(double time) {
        this.time = time;
        return this;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
