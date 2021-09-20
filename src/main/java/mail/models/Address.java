package mail.models;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Address {
    
    private String display;
    
    private String address;
    
    @SerializedName("is_group")
    private boolean group;
    
    private String name;
    
    public String getDisplay() {
        return display;
    }
    
    public Address setDisplay(String display) {
        this.display = display;
        return this;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Address setAddress(String address) {
        this.address = address;
        return this;
    }
    
    public boolean isGroup() {
        return group;
    }
    
    public Address setGroup(boolean group) {
        this.group = group;
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public Address setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
