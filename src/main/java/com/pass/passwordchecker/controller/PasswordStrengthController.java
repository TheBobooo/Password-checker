package com.pass.passwordchecker.controller;

import com.pass.passwordchecker.model.PasswordCheckRequest;
import com.pass.passwordchecker.model.PasswordCheckResponse;
import com.pass.passwordchecker.service.PasswordStrengthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/password")
@CrossOrigin(origins = "http://localhost:63342")
public class PasswordStrengthController {

    @Autowired
    private PasswordStrengthService passwordStrengthService;

    @PostMapping("/check")
    public PasswordCheckResponse checkPassword(@RequestBody PasswordCheckRequest request) {
        return passwordStrengthService.checkPasswordStrength(request.getPassword());
    }
}