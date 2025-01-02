package com.example.lesson_assumed_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson_assumed_app.model.Lesson;
import com.example.lesson_assumed_app.repository.CreateRepository;
import com.example.lesson_assumed_app.service.HomeService;


@Controller
public class CreateController {
    private final CreateRepository createRepository;

    @Autowired
    private HomeService homeService;

    public CreateController(CreateRepository createRepository){
        this.createRepository = createRepository;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/home")
    public String postMethodName(@RequestParam("studentName") String studentName,
                            @RequestParam("lessonMemo") String lessonMemo,
                            Model model) {
        // DBにレッスン記録を登録
        createRepository.createLesson(studentName, lessonMemo);
        List<Lesson> lessons = homeService.getAllLessons();
        model.addAttribute("lessons", lessons);
        return "redirect:/home";
    }
}
