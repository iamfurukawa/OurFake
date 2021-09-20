package document.models;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BankAccount {
    
    private String id;
    
    @SerializedName("conta")
    private String account;
    
    @SerializedName("agencia")
    private String branch;
    
    @SerializedName("banco")
    private String bank;
    
    @SerializedName("cidade")
    private String city;
    
    @SerializedName("estado")
    private String state;
    
    public String getId() {
        return id;
    }
    
    public BankAccount setId(String id) {
        this.id = id;
        return this;
    }
    
    public String getAccount() {
        return account;
    }
    
    public BankAccount setAccount(String account) {
        this.account = account;
        return this;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public BankAccount setBranch(String branch) {
        this.branch = branch;
        return this;
    }
    
    public String getBank() {
        return bank;
    }
    
    public BankAccount setBank(String bank) {
        this.bank = bank;
        return this;
    }
    
    public BankAccount setBank(Bank bank) {
        this.bank = bank.name();
        return this;
    }
    
    public String getCity() {
        return city;
    }
    
    public BankAccount setCity(String city) {
        this.city = city;
        return this;
    }
    
    public String getState() {
        return state;
    }
    
    public BankAccount setState(String state) {
        this.state = state;
        return this;
    }
    
    public BankAccount setState(State state) {
        this.state = state.name();
        return this;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
