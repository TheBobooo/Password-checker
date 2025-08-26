package com.pass.passwordchecker.model;

import lombok.Data; // From Lombok dependency

@Data // Generates getters, setters, toString, equals, hashCode
public class PasswordCheckRequest {
    private String password;
}