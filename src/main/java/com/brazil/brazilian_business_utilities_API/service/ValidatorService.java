package com.brazil.brazilian_business_utilities_API.service;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public boolean validateCPF(String cpf) {
        if (cpf == null) return false;

        // Remove non-digits
        cpf = cpf.replaceAll("\\D", "");

        // Check length
        if (cpf.length() != 11) return false;

        // Check if all digits are the same
        if (cpf.matches("(\\d)\\1{10}")) return false;

        // Calculate first verification digit
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) firstDigit = 0;

        // Check first digit
        if (Character.getNumericValue(cpf.charAt(9)) != firstDigit) return false;

        // Calculate second verification digit
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) secondDigit = 0;

        // Check second digit
        return Character.getNumericValue(cpf.charAt(10)) == secondDigit;
    }

    public String formateCPF(String cpf) {
        if (cpf == null) return null;
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11) return cpf;
        return String.format("%s.%s.%s-%s",
                cpf.substring(0, 3),
                cpf.substring(3, 6),
                cpf.substring(6, 9),
                cpf.substring(9, 11));
    }

    public boolean validateCNPJ(String cnpj) {
        if (cnpj == null) return false;

        // Remove non-digits
        cnpj = cnpj.replaceAll("\\D", "");

        // Check length
        if (cnpj.length() != 14) return false;

        // Check if all digits are the same
        if (cnpj.matches("(\\d)\\1{13}")) return false;

        // Calculate first verification digit
        int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weights1[i];
        }
        int firstDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);

        // Check first digit
        if (Character.getNumericValue(cnpj.charAt(12)) != firstDigit) return false;

        // Calculate second verification digit
        int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weights2[i];
        }
        int secondDigit = sum % 11 < 2 ? 0 : 11 - (sum % 11);

        // Check second digit
        return Character.getNumericValue(cnpj.charAt(13)) == secondDigit;
    }

    public String formateCNPJ(String cnpj) {
        if (cnpj == null) return null;
        cnpj = cnpj.replaceAll("\\D", "");
        if (cnpj.length() != 14) return cnpj;
        return String.format("%s.%s.%s/%s-%s",
                cnpj.substring(0, 2),
                cnpj.substring(2, 5),
                cnpj.substring(5, 8),
                cnpj.substring(8, 12),
                cnpj.substring(12, 14));
    }
}
