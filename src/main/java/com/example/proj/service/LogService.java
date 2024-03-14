package com.example.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proj.domain.Login;
import com.example.proj.repository.LogRepo;

@Service
public class LogService {
    @Autowired
    private LogRepo rep;

    public Login log(String username, String password) {
        Login user = rep.findByUsernameAndPassword(username, password);
        return user;
    }
}
