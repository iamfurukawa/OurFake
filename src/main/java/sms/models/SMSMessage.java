package sms.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static sms.models.SMSMessageType.STARTING;

public class SMSMessage {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SMSMessage.class);
    
    private String message;
    
    private SMSMessageType type;
    
    public SMSMessage() {
        this.message = "";
        this.type = STARTING;
    }
    public String getMessage() {
        return message;
    }
    
    public SMSMessage setMessage(final String message) {
        this.message = message;
        return this;
    }
    
    public SMSMessageType getType() {
        return type;
    }
    
    public SMSMessage setType(final SMSMessageType type) {
        this.type = type;
        return this;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
    public Optional<String> findDigits() {
        LOGGER.debug("m=findDigits stage=init message={}", message);
        var matcher = Pattern.compile("[0-9]{6}")
                .matcher(message);
    
        
        if (matcher.find()) {
            var digits = matcher.group().trim();
            LOGGER.debug("m=findDigits stage=end digits={}", digits);
            return Optional.of(digits);
        }
    
        LOGGER.debug("m=findDigits stage=error Digits not found returning null.");
        return Optional.empty();
    }
    
    public Map<String, Object> toMap() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(this, Map.class);
    }
    
}
