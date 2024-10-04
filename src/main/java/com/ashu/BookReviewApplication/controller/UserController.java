package com.ashu.BookReviewApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashu.BookReviewApplication.model.User;
import com.ashu.BookReviewApplication.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationform(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }
}
