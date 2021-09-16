package com.wildcodeschool.blog.controller;

import com.wildcodeschool.blog.payload.request.RegisterRequest;
import com.wildcodeschool.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    // Formulaire d'authentification
    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if (authService.register(registerRequest)) {
            return ResponseEntity.status(HttpStatus.OK).body("Utilisateur bien enregistré");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("L'utilisateur n'a pas été enregistré");
    }
}
