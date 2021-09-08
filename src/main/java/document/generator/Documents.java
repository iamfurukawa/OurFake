package document.generator;

import java.security.SecureRandom;

public class Documents {
    
    private static final int[] MULTIPLICADORES_CPF = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    
    private static final int[] MULTIPLICADORES_CNPJ = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6};
    
    private static final SecureRandom RND = new SecureRandom();
    
    private Documents() {
    }
    
    public static String generateCPF(boolean withMask) {
        var cpf = gerarCPFCNPJ(9, MULTIPLICADORES_CPF);
        return withMask ? formatarCPF(cpf) : cpf;
    }
    
    public static String generateCNPJ(boolean withMask) {
        var cnpj = gerarCPFCNPJ(12, MULTIPLICADORES_CNPJ);
        return withMask ? formatarCNPJ(cnpj) : cnpj;
    }
    
    private static String formatarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve possuir 11 dígitos");
        }
        
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9, 11));
    }
    
    private static String formatarCNPJ(String cnpj) {
        if (cnpj == null || cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ deve possuir 14 dígitos");
        }
        
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