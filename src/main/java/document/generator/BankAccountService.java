package document.generator;

import com.google.gson.Gson;
import document.models.Bank;
import document.models.BankAccount;
import document.models.State;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccountService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountService.class);
    
    private static final String BASE_URL = "https://www.invertexto.com/ajax/gerar-conta-bancaria.php";
    
    private final OkHttpClient client = new OkHttpClient();
    
    private final Gson gson = new Gson();
    
    public BankAccount getBankAccountFrom(Bank bank, State state) {
        LOGGER.info("m=getBankAccount stage=init bank={} state={}", bank, state);
        //This API is based on https://www.invertexto.com/gerador-de-conta-bancaria
    
        var formBody = new FormBody.Builder()
                .add("banco", String.valueOf(bank.getId()))
                .add("estado", state.getState()).build();
    
        var request = new Request.Builder()
                .url(BASE_URL)
                .post(formBody)
                .build();
        
        try {
            var responseApi = client.newCall(request).execute();
            var response = gson.fromJson(responseApi.body().string(), BankAccount.class);
            LOGGER.info("m=getBankAccount stage=end response={}", response);
            return response;
        } catch (Exception e) {
            LOGGER.error("m=getBankAccount stage=error returning default bank. stacktrace={}", e.getStackTrace());
            return new BankAccount()
                    .setBranch("4869")
                    .setBank(Bank.BANCO_DO_BRASIL)
                    .setState(State.SP)
                    .setCity("Sao Bernardo Do Campo")
                    .setAccount("1239459-9")
                    .setId("1");
        }
    }
}
