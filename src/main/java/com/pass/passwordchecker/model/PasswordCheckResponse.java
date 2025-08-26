package com.pass.passwordchecker.model;

import lombok.Builder; // From Lombok dependency
import lombok.Data;

@Data
@Builder
public class PasswordCheckResponse {
    private String strength;
    private String message;
}