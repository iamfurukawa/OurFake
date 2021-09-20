package document.models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public enum Bank {
    BANCO_DO_BRASIL(1), BRADESCO(2), CAIXA(3), ITAU(4), SANTANDER(5);
    
    private int bank;
    
    Bank(int bank) {
        this.bank = bank;
    }
    
    public int getId() {
        return bank;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
