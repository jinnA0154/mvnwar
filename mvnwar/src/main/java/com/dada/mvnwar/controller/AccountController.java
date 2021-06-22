package com.dada.mvnwar.controller;

import com.dada.mvnwar.model.User;
import com.dada.mvnwar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/register")
    public String register() {

        return "account/register";
    }

    //로그인이 완료가 되었을때...
    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/";
    }

}
