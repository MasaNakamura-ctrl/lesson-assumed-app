package com.example.lesson_assumed_app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String login(){
        return "login";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
