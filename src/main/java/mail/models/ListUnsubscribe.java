package mail.models;

import java.util.List;

public class ListUnsubscribe {
    
    private List<String> address;
    
    private List<String> links;
    
    public List<String> getAddress() {
        return address;
    }
    
    public ListUnsubscribe setAddress(List<String> address) {
        this.address = address;
        return this;
    }
    
    public List<String> getLinks() {
        return links;
    }
    
    public ListUnsubscribe setLinks(List<String> links) {
        this.links = links;
        return this;
    }
    
}
