package com.example.lesson_assumed_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson_assumed_app.entity.ReadEntity;
import com.example.lesson_assumed_app.repository.ReadRepository;

@Controller
@RequestMapping("/read")
public class ReadController {
    private final ReadRepository readRepository;

    public ReadController(ReadRepository readRepository){
        this.readRepository = readRepository;
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
            return "home";
        }
    }
}