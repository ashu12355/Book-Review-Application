package com.ashu.BookReviewApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashu.BookReviewApplication.model.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";  // Refers to login.html
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());  // Bind a new user object to the form
        return "register";  // Refers to register.html
    }
}
