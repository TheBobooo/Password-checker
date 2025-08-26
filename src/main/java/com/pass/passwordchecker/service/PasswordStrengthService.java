package com.pass.passwordchecker.service;

import com.pass.passwordchecker.model.PasswordCheckResponse;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service component
public class PasswordStrengthService {

    public PasswordCheckResponse checkPasswordStrength(String password) {
        StringBuilder message = new StringBuilder();
        int nr = 0;
        if (password == null || password.isEmpty()) {
            return PasswordCheckResponse.builder()
                    .strength("No Password")
                    .message("Password cannot be empty.")
                    .build();
        }


        if (password.length() >= 8) {
           nr+=1;
        } else {
            message.append("Minimum 8 characters required. ");
        }

        // Rule 2: Uppercase letters
        if (password.matches(".*[A-Z].*")) {
            nr++;
        } else {
            message.append("Include uppercase letters. ");
        }

        // Rule 3: Lowercase letters
        if (password.matches(".*[a-z].*")) {
        nr++;
        } else {
            message.append("Include lowercase letters. ");
        }

        // Rule 4: Digits
        if (password.matches(".*\\d.*")) {
        nr++;
        } else {
            message.append("Include digits. ");
        }

        // Rule 5: Special characters
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
        nr++;
        } else {
            message.append("Include special characters. ");
        }

        // Determine strength based on score
        String strength;
        if (nr == 6) {
            strength = "Very Very Strong";
            message.setLength(0); // Clear message if perfect
            message.append("Excellent password!");
        }else if (nr == 5) {
            strength = "Very Strong";
            message.setLength(0);
            message.append("Good Password!");
        }
        else if (nr == 4) {
            strength = "Strong";
            if (message.length() == 0) message.append("Good password, but could be stronger.");
        } else if (nr == 3) {
            strength = "Moderate";
        } else if (nr == 2) {
            strength = "Weak";
        } else {
            strength = "Very Weak";
        }

        if (message.length() == 0 && nr < 5) {
            message.append("Consider adding more variety for a stronger password.");
        }

        return PasswordCheckResponse.builder()
                .strength(strength)
                .message(message.toString().trim())
                .build();
    }
}