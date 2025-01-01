package com.example.lesson_assumed_app.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateRepository {
    private final JdbcTemplate jdbcTemplate;

    public UpdateRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int updateLesson(int id, String studentName, String lessonMemo){
        String sql = "UPDATE history SET studentName = ?, lessonMemo = ? WHERE id = ?";
        return jdbcTemplate.update(sql, studentName, lessonMemo, id);
    }
}
