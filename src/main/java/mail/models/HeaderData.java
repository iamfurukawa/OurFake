package mail.models;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

public class HeaderData {
    
    private String subject;
    
    @SerializedName("fromstr")
    private String fromStr;
    
    private List<Address> from;
    
    @SerializedName("tostr")
    private String toStr;
    
    private List<Address> to;
    
    @SerializedName("ccstr")
    private boolean ccStr;
    
    private List<Address> cc;
    
    @SerializedName("replytostr")
    private boolean replyToStr;
    
    @SerializedName("replyto")
    private List<Address> replyTo;
    
    private String date;
    
    @SerializedName("list-unsubscribe")
    private ListUnsubscribe listUnsubscribe;
    
    @SerializedName("receivelist")
    private List<Address> receiveList;
    
    @SerializedName("replylist")
    private List<Address> replyList;
    
    @SerializedName("receiveaddress")
    private List<String> receiveAddress;
    
    @SerializedName("replyaddress")
    private List<String> replyAddress;
    
    public String getSubject() {
        return subject;
    }
    
    public HeaderData setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    
    public String getFromStr() {
        return fromStr;
    }
    
    public HeaderData setFromStr(String fromStr) {
        this.fromStr = fromStr;
        return this;
    }
    
    public List<Address> getFrom() {
        return from;
    }
    
    public HeaderData setFrom(List<Address> from) {
        this.from = from;
        return this;
    }
    
    public String getToStr() {
        return toStr;
    }
    
    public HeaderData setToStr(String toStr) {
        this.toStr = toStr;
        return this;
    }
    
    public List<Address> getTo() {
        return to;
    }
    
    public HeaderData setTo(List<Address> to) {
        this.to = to;
        return this;
    }
    
    public boolean isCcStr() {
        return ccStr;
    }
    
    public HeaderData setCcStr(boolean ccStr) {
        this.ccStr = ccStr;
        return this;
    }
    
    public List<Address> getCc() {
        return cc;
    }
    
    public HeaderData setCc(List<Address> cc) {
        this.cc = cc;
        return this;
    }
    
    public boolean isReplyToStr() {
        return replyToStr;
    }
    
    public HeaderData setReplyToStr(boolean replyToStr) {
        this.replyToStr = replyToStr;
        return this;
    }
    
    public List<Address> getReplyTo() {
        return replyTo;
    }
    
    public HeaderData setReplyTo(List<Address> replyTo) {
        this.replyTo = replyTo;
        return this;
    }
    
    public String getDate() {
        return date;
    }
    
    public HeaderData setDate(String date) {
        this.date = date;
        return this;
    }
    
    public ListUnsubscribe getListUnsubscribe() {
        return listUnsubscribe;
    }
    
    public HeaderData setListUnsubscribe(ListUnsubscribe listUnsubscribe) {
        this.listUnsubscribe = listUnsubscribe;
        return this;
    }
    
    public List<Address> getReceiveList() {
        return receiveList;
    }
    
    public HeaderData setReceiveList(List<Address> receiveList) {
        this.receiveList = receiveList;
        return this;
    }
    
    public List<Address> getReplyList() {
        return replyList;
    }
    
    public HeaderData setReplyList(List<Address> replyList) {
        this.replyList = replyList;
        return this;
    }
    
    public List<String> getReceiveAddress() {
        return receiveAddress;
    }
    
    public HeaderData setReceiveAddress(List<String> receiveAddress) {
        this.receiveAddress = receiveAddress;
        return this;
    }
    
    public List<String> getReplyAddress() {
        return replyAddress;
    }
    
    public HeaderData setReplyAddress(List<String> replyAddress) {
        this.replyAddress = replyAddress;
        return this;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
