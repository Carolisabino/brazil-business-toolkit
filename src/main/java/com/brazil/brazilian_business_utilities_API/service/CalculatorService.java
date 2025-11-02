package com.brazil.brazilian_business_utilities_API.service;

import com.brazil.brazilian_business_utilities_API.dto.FGTSResponse;
import com.brazil.brazilian_business_utilities_API.dto.FgtsRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {
    public FGTSResponse calculateFGTS(FgtsRequest request) {
        // FGTS is 8% of salary
        BigDecimal monthlySalary = request.getMonthlySalary();
        BigDecimal fgtsRate = new BigDecimal("0.08");

        BigDecimal monthlyFgts = monthlySalary.multiply(fgtsRate)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalFgts = monthlyFgts.multiply(new BigDecimal(request.getMonthsWorked()))
                .setScale(2, RoundingMode.HALF_UP);

        return FGTSResponse.builder()
                .monthlySalary(monthlySalary)
                .monthsWorked(request.getMonthsWorked())
                .monthlyFGRTSDeposity(monthlyFgts)
                .totalFGTSBalance(totalFgts)
                .fgtsRate("8%")
                .build();
    }
}
