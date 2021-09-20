package document.models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public enum Bank {
    BANCO_DO_BRASIL(1), BRADESCO(2), CAIXA(3), ITAU(4), SANTANDER(5);
    
    private int bankActual;
    
    Bank(int bank) {
        this.bankActual = bank;
    }
    
    public int getId() {
        return bankActual;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
