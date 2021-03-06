package document.models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public enum State {
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"), GO("GO"),
    MA("MA"), MT("MT"), MS("MS"), MG("MG"), PR("PR"), PB("PB"), PA("PA"), PE("PE"), PI("PI"),
    RJ("RJ"), RN("RN"), RS("RS"), RO("RO"), RR("RR"), SC("SC"), SE("SE"), SP("SP"), TO("TO");
    
    private final String stateActual;
    
    State(String state) {
        this.stateActual = state;
    }
    
    public String getState() {
        return stateActual;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
