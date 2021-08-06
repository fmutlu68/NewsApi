package com.fm.newsProject.api.controllers;

import com.fm.newsProject.core.entities.concretes.UserDtoForLogin;
import com.fm.newsProject.core.entities.concretes.UserDtoForRegister;
import com.fm.newsProject.services.abstracts.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDtoForLogin user){
        var result = authService.login(user);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else{
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDtoForRegister user){
        var result = authService.register(user);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else{
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
    }
}
