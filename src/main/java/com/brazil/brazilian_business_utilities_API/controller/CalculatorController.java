package com.brazil.brazilian_business_utilities_API.controller;

import com.brazil.brazilian_business_utilities_API.dto.FGTSResponse;
import com.brazil.brazilian_business_utilities_API.dto.FgtsRequest;
import com.brazil.brazilian_business_utilities_API.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculate")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController (CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @PostMapping("/fgts")
    public ResponseEntity<FGTSResponse> calculateFGTS (@Valid @RequestBody FgtsRequest request) {
        FGTSResponse response = calculatorService.calculateFGTS(request);
        return ResponseEntity.ok(response);
    }
}
