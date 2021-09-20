package our_fake;

import document.models.Bank;
import document.models.BankAccount;
import document.generator.BankAccountService;
import document.generator.Documents;
import document.models.State;
import google.services.RealtimeDatabase;
import mail.models.Inbox;
import mail.models.InboxItem;
import mail.models.InboxMail;
import mail.services.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sms.models.SMSMessage;

import java.util.Optional;

import static sms.models.SMSMessageType.*;

public class OurFake {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OurFake.class);
    
    public static final int RETRY_LIMIT = 100;
    
    public static final Long ONE_SECOND = 1000L;
    
    private RealtimeDatabase realtimeDatabase = null;
    
    private SMSMessage state = new SMSMessage();
    
    private BankAccountService bankAccountService = new BankAccountService();
    
    private MailService mailService = new MailService();
    
    public OurFake() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (realtimeDatabase != null) realtimeDatabase.createOrUpdate(state.setType(DISCONNECTED));
        }));
    }
    
    public Optional<SMSMessage> waitForPhoneCode(String phoneNumber) {
        return waitForPhoneCode(phoneNumber, RETRY_LIMIT);
    }
    
    public Optional<SMSMessage> waitForPhoneCode(String phoneNumber, int retryLimit) {
    
        setupPhoneCode(phoneNumber);
    
        LOGGER.info("m=waitForPhoneCode stage=init phoneNumber={}", phoneNumber);
        realtimeDatabase.createOrUpdate(state.setType(WAITING_FOR_UPDATES));
        
        try {
            for (int tentative = 0; tentative < retryLimit; tentative++) {
                LOGGER.info("m=waitForPhoneCode stage=retry_retrieve tentative={}", tentative);
                state = realtimeDatabase.retrieve();
                
                if(state.getType() == FLUTTER_HAS_CHANGED) {
                    LOGGER.info("m=waitForPhoneCode stage=validate_retrieve sms_received={}", state);
                    break;
                }
                
                Thread.sleep(3 * ONE_SECOND); //5 minutes by default 300 sec. (3 * 1000 * 100)
            }
    
            realtimeDatabase.createOrUpdate(state.setType(DISCONNECTED));
            LOGGER.info("m=waitForPhoneCode stage=end state={}", state);
            return Optional.of(state);
        } catch (Exception e) {
            LOGGER.error("m=waitForPhoneCode stage=error stacktrace={}", e);
            realtimeDatabase.createOrUpdate(state.setType(DISCONNECTED));
            return Optional.empty();
        }
    }
    
    private void setupPhoneCode(String phoneNumber) {
        LOGGER.info("m=setupPhoneCode stage=init phoneNumber={}", phoneNumber);
        if(realtimeDatabase == null) realtimeDatabase = new RealtimeDatabase(phoneNumber);
        realtimeDatabase.createOrUpdate(state);
        LOGGER.info("m=setupPhoneCode stage=end state={}", state);
    }
    
    public String generateCPF(boolean withMask) {
        LOGGER.info("m=generateCPF stage=init withMask={}", withMask);
        var cpf = Documents.generateCPF(withMask);
        LOGGER.info("m=generateCPF stage=end cpf={}", cpf);
        return cpf;
    }
    
    public String generateCNPJ(boolean withMask) {
        LOGGER.info("m=generateCNPJ stage=init withMask={}", withMask);
        var cnpj = Documents.generateCNPJ(withMask);
        LOGGER.info("m=generateCNPJ stage=end cnpj={}", cnpj);
        return cnpj;
    }
    
    public BankAccount generateBankAccount(Bank bank, State state) {
        LOGGER.info("m=generateBankAccount stage=init bank={} state={}", bank, state);
        var bankAccount = bankAccountService.getBankAccountFrom(bank, state);
        LOGGER.info("m=generateBankAccount stage=end bankAccount={}", bankAccount);
        return bankAccount;
    }
    
    public Inbox createNewEmailBox() throws Exception {
        LOGGER.info("m=createNewEmailBox stage=init");
        var inbox = mailService.createNewMailBox();
        LOGGER.info("m=createNewEmailBox stage=end inbox={}", inbox);
        return inbox;
    }
    
    public Inbox recoverEmailBox() throws Exception {
        LOGGER.info("m=recoverEmailBox stage=init");
        var inbox = mailService.recoverEmailBox();
        LOGGER.info("m=recoverEmailBox stage=end inbox={}", inbox);
        return inbox;
    }
    
    public Inbox retrieveInbox() throws Exception {
        LOGGER.info("m=retrieveInbox stage=init");
        var inbox = mailService.retrieveDataMailBox();
        LOGGER.info("m=retrieveInbox stage=end inbox={}", inbox);
        return inbox;
    }
    
    public Inbox increaseTime() throws Exception {
        LOGGER.info("m=increaseTime stage=init");
        var inbox = mailService.reset100Minutes();
        LOGGER.info("m=increaseTime stage=end inbox={}", inbox);
        return inbox;
    }
    
    public InboxMail retrieveMailBy(InboxItem email) throws Exception {
        LOGGER.info("m=retrieveMailBy stage=init mailId={}", email);
        var inboxMail = mailService.retrieveInboxMail(email.getEmailId());
        LOGGER.info("m=retrieveMailBy stage=end mail={}", inboxMail);
        return inboxMail;
    }
    
}
