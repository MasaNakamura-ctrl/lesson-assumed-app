package com.example.lesson_assumed_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson_assumed_app.entity.ReadEntity;
import com.example.lesson_assumed_app.model.Lesson;
import com.example.lesson_assumed_app.repository.DeleteRepository;
import com.example.lesson_assumed_app.repository.ReadRepository;
import com.example.lesson_assumed_app.service.HomeService;


@Controller
@RequestMapping("/read")
public class ReadController {
    private final ReadRepository readRepository;
    private final DeleteRepository deleteRepository;
    @Autowired
    private HomeService homeService;

    public ReadController(ReadRepository readRepository, DeleteRepository deleteRepository){
        this.readRepository = readRepository;
        this.deleteRepository = deleteRepository;
    }

    @GetMapping("/{id}")
    public String getRead(@PathVariable("id") int id, Model model) {
        try{
            // IDから該当するレコードを取得
            ReadEntity lessons = readRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
            model.addAttribute("lessons",lessons);
            return "read";
        } catch(IllegalArgumentException e){
            // 例外処理として記録一覧画面へ再度遷移
            // DBからレッスン記録を一通り取得
            List<Lesson> lessons = homeService.getAllLessons();
            model.addAttribute("lessons", lessons);
            return "home";
        }
    }

    @PostMapping("/home")
    public String deleteLesson(@RequestParam("id") int id, Model model) {
        try {
            // IDに該当するレコードを削除
            deleteRepository.deleteLesson(id);
        } catch (IllegalArgumentException e) {
        }
        List<Lesson> lessons = homeService.getAllLessons();
        model.addAttribute("lessons", lessons);
        return "home";
    }
}
