package com.example.lesson_assumed_app.service;

import com.example.lesson_assumed_app.model.Lesson;
import com.example.lesson_assumed_app.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private HomeRepository homeRepository;
    public List<Lesson> getAllLessons(){
        return homeRepository.findAll();
    }
}
