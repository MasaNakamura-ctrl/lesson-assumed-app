package com.example.lesson_assumed_app.repository;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public class CreateRepository {
    private final JdbcTemplate jdbcTemplate;

    public CreateRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // 排他制御で行ロックを使用
    @Transactional
    public int createLesson(String studentName, String lessonMemo){
        LocalDateTime now = LocalDateTime.now();
        String sql = "INSERT INTO history (lessonDate, studentName, lessonMemo) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, now, studentName, lessonMemo);
    }
}
