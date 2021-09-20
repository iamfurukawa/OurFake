package document.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

public class Documents {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Documents.class);
    
    private static final int[] MULTIPLICADORES_CPF = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    
    private static final int[] MULTIPLICADORES_CNPJ = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6};
    
    private static final SecureRandom RND = new SecureRandom();
    
    private Documents() { }
    
    public static String generateCPF(boolean withMask) {
        LOGGER.debug("m=generateCPF stage=init withMask={}", withMask);
        var cpf = gerarCPFCNPJ(9, MULTIPLICADORES_CPF);
        LOGGER.debug("m=generateCPF stage=end cpf={}", cpf);
        return withMask ? formatarCPF(cpf) : cpf;
    }
    
    public static String generateCNPJ(boolean withMask) {
        LOGGER.debug("m=generateCNPJ stage=init withMask={}", withMask);
        var cnpj = gerarCPFCNPJ(12, MULTIPLICADORES_CNPJ);
        LOGGER.debug("m=generateCNPJ stage=end cnpj={}", cnpj);
        return withMask ? formatarCNPJ(cnpj) : cnpj;
    }
    
    private static String formatarCPF(String cpf) {
        LOGGER.debug("m=formatarCPF stage=init cpf={}", cpf);
        if (cpf == null || cpf.length() != 11) {
            LOGGER.error("m=formatarCPF stage=error CPF deve possuir 11 dígitos");
            throw new IllegalArgumentException("CPF deve possuir 11 dígitos");
        }
    
        LOGGER.debug("m=formatarCPF stage=end");
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9, 11));
    }
    
    private static String formatarCNPJ(String cnpj) {
        LOGGER.debug("m=formatarCNPJ stage=init cnpj={}", cnpj);
        if (cnpj == null || cnpj.length() != 14) {
            LOGGER.error("m=formatarCNPJ stage=error CPF deve possuir 14 dígitos");
            throw new IllegalArgumentException("CNPJ deve possuir 14 dígitos");
        }
    
        LOGGER.debug("m=formatarCNPJ stage=end");
        return String.format("%s.%s.%s/%s-%s", cnpj.substring(0, 2), cnpj.substring(2, 5), cnpj.substring(5, 8), cnpj.substring(8, 12), cnpj.substring(12, 14));
    }
    
    private static String gerarCPFCNPJ(int tamanho, int[] multiplicadores) {
        var base = gerarStringNumerica(tamanho);
        var dv1 = calcularModulo11(base, multiplicadores);
        var dv2 = calcularModulo11(base.concat(dv1), multiplicadores);
        return base.concat(dv1).concat(dv2);
    }
    
    private static String gerarStringNumerica(int tamanho) {
        var sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(RND.nextInt(10));
        }
        return sb.toString();
    }
    
    public static String calcularModulo11(String base, int[] multiplicadores) {
        var soma = 0;
        for (int i = base.length() - 1, j = 0; i >= 0; i--, j++) {
            soma += multiplicadores[j] * Integer.parseInt(String.valueOf(base.charAt(i)));
        }
        
        var resto = soma % 11;
        var dv = resto > 1 ? 11 - resto : 0;
        return String.valueOf(dv);
    }
    
}