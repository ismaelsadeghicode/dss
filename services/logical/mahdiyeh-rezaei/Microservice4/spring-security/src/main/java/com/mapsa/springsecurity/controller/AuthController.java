package com.mapsa.springsecurity.controller;

import com.mapsa.springsecurity.data.jwt.Request;
import com.mapsa.springsecurity.data.jwt.Response;
import com.mapsa.springsecurity.domain.User;
import com.mapsa.springsecurity.repository.UserRepository;
import com.mapsa.springsecurity.service.AuthService;
import com.mapsa.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("register")
    public ResponseEntity<User> saveUser(@RequestBody Request request){
        return ResponseEntity.ok(userService.saveUser(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<Response> createToken(@RequestBody Request request){ //or string
        return ResponseEntity.ok(authService.createToken(request));
    }
}
