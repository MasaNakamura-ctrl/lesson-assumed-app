package com.example.lesson_assumed_app.repository;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateRepository {
    private final JdbcTemplate jdbcTemplate;

    public CreateRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createLesson(String studentName, String lessonMemo){
        LocalDateTime now = LocalDateTime.now();
        String sql = "INSERT INTO history (lessonDate, studentName, lessonMemo) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, now, studentName, lessonMemo);
    }
}
