package com.example.lesson_assumed_app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/read")
    public String read(){
        return "read";
    }
    @GetMapping("/update")
    public String update(){
        return "update";
    }
    @GetMapping("/create")
    public String create() {
        return "create";
    }
}
