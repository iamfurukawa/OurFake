package our_fake;

import document.models.Bank;
import document.models.BankAccount;
import document.generator.BankAccountService;
import document.generator.Documents;
import document.models.State;
import google.services.RealtimeDatabase;
import mail.services.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sms.models.SMSMessage;

import java.io.IOException;
import java.util.Optional;

import static sms.models.SMSMessageType.*;

public class OurFake {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OurFake.class);
    
    public static final int RETRY_LIMIT = 50;
    
    public static final Long ONE_SECOND = 1000L;
    
    private RealtimeDatabase realtimeDatabase = null;
    
    private SMSMessage state = new SMSMessage();
    
    public OurFake() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (realtimeDatabase != null) realtimeDatabase.createOrUpdate(state.setType(DISCONNECTED));
        }));
    }
    
    public Optional<SMSMessage> waitForPhoneCode(String phoneNumber) {
    
        setupPhoneCode(phoneNumber);
    
        LOGGER.info("m=waitForPhoneCode stage=init");
        realtimeDatabase.createOrUpdate(state.setType(WAITING_FOR_UPDATES));
        
        try {
            for (int tentative = 0; tentative < RETRY_LIMIT; tentative++) {
                LOGGER.info("m=waitForPhoneCode stage=retry_retrieve tentative={}", tentative);
                state = realtimeDatabase.retrieve();
                
                if(state.getType() == FLUTTER_HAS_CHANGED) {
                    LOGGER.info("m=waitForPhoneCode stage=validate_retrieve sms_received={}", state.toString());
                    break;
                }
                
                Thread.sleep(3 * ONE_SECOND);
            }
    
            realtimeDatabase.createOrUpdate(state.setType(DISCONNECTED));
            LOGGER.info("m=waitForPhoneCode stage=end");
            return Optional.of(state);
        } catch (Exception e) {
            LOGGER.info("m=waitForPhoneCode stage=error stacktrace={}", e.toString());
            realtimeDatabase.createOrUpdate(state.setType(DISCONNECTED));
            return Optional.empty();
        }
    }
    
    private void setupPhoneCode(String phoneNumber) {
        LOGGER.info("m=setupPhoneCode stage=init");
        if(realtimeDatabase == null) realtimeDatabase = new RealtimeDatabase(phoneNumber);
        realtimeDatabase.createOrUpdate(state);
        LOGGER.info("m=setupPhoneCode stage=end");
    }
    
    public String generateCPF(boolean withMask) {
        return Documents.generateCPF(withMask);
    }
    
    public String generateCNPJ(boolean withMask) {
        return Documents.generateCNPJ(withMask);
    }
    
    public BankAccount generateBankAccount(Bank bank, State state) {
        BankAccountService bankAccountService = new BankAccountService();
        return bankAccountService.getBankAccount(bank, state);
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        OurFake ourFake = new OurFake();
        //SMSMessage message = ourFake.waitForPhoneCode("12345678910").get();
        
        //System.out.println("\n\n\n\n\n\n");
//        System.out.println(message.findDigits());
//        System.out.println(message.getMessage());
//        System.out.println(message);
        //System.out.println(ourFake.generateCPF(false));
//        BankAccount acc = ourFake.generateBankAccount(Bank.BANCO_DO_BRASIL, State.SP);
//        System.out.println(acc.toString());
    
        MailService ms = new MailService();

        var res =  ms.createNewMailBox();
        System.out.println(res.toString()+"\n");
        
        var email = ms.retrieveInboxMail("welcome");
        System.out.println(email.getHtml().get(0));
    
        //System.out.println("\n\n\n\n\n\n");
    }
    
}
