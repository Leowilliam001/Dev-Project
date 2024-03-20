package com.example.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proj.domain.Login;
import com.example.proj.repository.LogRepo;

@Service
public class RegService {
    @Autowired
    private LogRepo userRepository;

    public Login saveUser(String username, String password) {
        Login user = new Login();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

}
