package com.example.lesson_assumed_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lesson_assumed_app.model.Lesson;
import com.example.lesson_assumed_app.service.HomeService;

@Controller
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public String home(Model model){
        // DBからレッスン記録を一通り取得
        List<Lesson> lessons = homeService.getAllLessons();
        model.addAttribute("lessons", lessons);
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
