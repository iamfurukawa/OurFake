package document.models;

public enum State {
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"), GO("GO"),
    MA("MA"), MT("MT"), MS("MS"), MG("MG"), PR("PR"), PB("PB"), PA("PA"), PE("PE"), PI("PI"),
    RJ("RJ"), RN("RN"), RS("RS"), RO("RO"), RR("RR"), SC("SC"), SE("SE"), SP("SP"), TO("TO");
    
    private String state;
    
    State(String state) {
        this.state = state;
    }
}
