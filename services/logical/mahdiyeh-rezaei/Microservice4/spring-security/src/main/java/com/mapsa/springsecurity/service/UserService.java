package com.mapsa.springsecurity.service;

import com.mapsa.springsecurity.data.jwt.Request;
import com.mapsa.springsecurity.domain.User;
import com.mapsa.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(Request request){
        User user = new User()
                .setUsername(request.getUsername())
                .setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }
}
