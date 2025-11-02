package com.brazil.brazilian_business_utilities_API.controller;

import com.brazil.brazilian_business_utilities_API.dto.ValidationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brazil.brazilian_business_utilities_API.service.ValidatorService;

@RestController
@RequestMapping("api/v1/validate")
public class ValidatorController {

    private final ValidatorService validatorService;

    public ValidatorController(ValidatorService validatorService){
        this.validatorService = validatorService;
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ValidationResponse> validateCPF(@PathVariable String cpf) {
        boolean isValid = validatorService.validateCPF(cpf);
        String formatted = validatorService.formateCPF(cpf);

        return ResponseEntity.ok(ValidationResponse.builder()
                .type("CPF")
                .input(cpf)
                .valid(isValid)
                .formatted(formatted)
                .message(isValid ? "Valid CPF" : "Invalid CPF")
                .build());
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<ValidationResponse> validateCNPJ(@PathVariable String cnpj) {
        boolean isValid = validatorService.validateCNPJ(cnpj);
        String formatted = validatorService.formateCNPJ(cnpj);

        return ResponseEntity.ok(ValidationResponse.builder()
                .type("CNPJ")
                .input(cnpj)
                .valid(isValid)
                .formatted(formatted)
                .message(isValid ? "Valid CNPJ" : "Invalid CNPJ")
                .build());
    }

}
