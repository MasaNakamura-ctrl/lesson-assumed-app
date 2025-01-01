package com.example.lesson_assumed_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson_assumed_app.entity.ReadEntity;
import com.example.lesson_assumed_app.model.Lesson;
import com.example.lesson_assumed_app.repository.ReadRepository;
import com.example.lesson_assumed_app.service.HomeService;


@Controller
@RequestMapping("/update")
public class UpdateController {
    private final ReadRepository readRepository;
    @Autowired
    private HomeService homeService;

    public UpdateController(ReadRepository readRepository){
        this.readRepository = readRepository;
    }

    @GetMapping("/{id}")
    public String getUpdate(@PathVariable("id") int id, Model model) {
        try{
            // IDから該当するレコードを取得
            ReadEntity lessons = readRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
            model.addAttribute("lessons",lessons);
            return "update";
        } catch(IllegalArgumentException e){
            // 例外処理として記録一覧画面へ再度遷移
            // DBからレッスン記録を一通り取得
            List<Lesson> lessons = homeService.getAllLessons();
            model.addAttribute("lessons", lessons);
            return "home";
        }
    }
}
