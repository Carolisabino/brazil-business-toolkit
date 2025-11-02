package com.brazil.brazilian_business_utilities_API.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class FgtsRequest {
    @NotNull(message = "Monthly salary is required")
    @DecimalMin(value = "0.01", message = "Salary must be greater than 0")
    private BigDecimal monthlySalary;

    @NotNull(message = "Months worked is required")
    @Min(value = 1, message = "Months worked must be at least 1")
    @Max(value = 600, message = "Months worked cannot exceed 600")
    private Integer monthsWorked;
}
