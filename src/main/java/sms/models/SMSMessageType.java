package sms.models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public enum SMSMessageType {
    STARTING, WAITING_FOR_UPDATES, FLUTTER_HAS_CHANGED, DISCONNECTED;
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
