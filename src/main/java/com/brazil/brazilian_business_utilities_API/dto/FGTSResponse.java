package com.brazil.brazilian_business_utilities_API.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class FGTSResponse {
    private BigDecimal monthlySalary;
    private Integer monthsWorked;
    private BigDecimal monthlyFGRTSDeposity;
    private BigDecimal totalFGTSBalance;
    private String fgtsRate;
}
