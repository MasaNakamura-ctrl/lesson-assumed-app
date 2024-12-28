package com.example.lesson_assumed_app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login(){
        return "login";
    }
    @PostMapping("/check")
    public String postIdPassword(
        @RequestParam("id") String id,
        @RequestParam("password") String password,
        Model model){
        return "home";
    }
}
