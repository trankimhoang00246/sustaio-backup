package com.codejava.course.controller;

import com.codejava.course.model.form.LoginForm;
import com.codejava.course.model.form.RegisterForm;
import com.codejava.course.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginForm form){
        return ResponseEntity.ok(authService.login(form));
    }

    @PostMapping("/register")
    public ResponseEntity<String> login(@RequestBody @Valid RegisterForm form){
        return ResponseEntity.ok(authService.register(form));
    }

    @GetMapping("/refresh")
    public ResponseEntity refreshToken(@RequestHeader("X-Refresh-Token") String refreshToken){
        return ResponseEntity.ok(authService.refreshJWT(refreshToken));
    }
}
