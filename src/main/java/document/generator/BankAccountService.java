package document.generator;

import com.google.gson.Gson;
import document.models.Bank;
import document.models.BankAccount;
import document.models.State;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class BankAccountService {
    
    private static final String BASE_URL = "https://www.invertexto.com/ajax/gerar-conta-bancaria.php";
    
    private final OkHttpClient client = new OkHttpClient();
    
    private final Gson gson = new Gson();
    
    public BankAccount getBankAccount(Bank bank, State state) {
        //This API is based on https://www.invertexto.com/gerador-de-conta-bancaria
    
        var formBody = new FormBody.Builder()
                .add("banco", String.valueOf(bank.getId()))
                .add("estado", state.toString()).build();
    
        var request = new Request.Builder()
                .url(BASE_URL)
                .post(formBody)
                .build();
        
        try {
            var response = client.newCall(request)
                    .execute();
            return gson.fromJson(response.body().string(), BankAccount.class);
        } catch (Exception e) {
            System.out.println("ERRO");
            e.printStackTrace();
            return new BankAccount().setBranch("4869").setBank(Bank.BANCO_DO_BRASIL).setState(State.SP)
                    .setCity("Sao Bernardo Do Campo").setAccount("1239459-9").setId("1");
        }
    }
}
