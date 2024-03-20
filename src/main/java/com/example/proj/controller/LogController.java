package com.example.proj.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proj.domain.Login;
import com.example.proj.service.LogService;
import com.example.proj.service.RegService;

@Controller

public class LogController {

    @Autowired
    private LogService service;

    @GetMapping("/")
    public String api() {

        return "log";
    }

    @PostMapping("/log")
    public String login(@ModelAttribute("user") Login user) {

        Login oauthUser = service.log(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/display";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/display")
    public String display() {
        return "display";
    }

    @Autowired
    private RegService service2;

    @GetMapping("/register")
    public String api2() {

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") Login user) {

        Login oauthUser = service2.saveUser(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/disp2";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/disp2")
    public String disp2() {
        return "disp2";
    }

}
