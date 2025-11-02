package com.brazil.brazilian_business_utilities_API.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class ValidationResponse {
    private String type;
    private String input;
    private boolean valid;
    private String formatted;
    private String message;
}


