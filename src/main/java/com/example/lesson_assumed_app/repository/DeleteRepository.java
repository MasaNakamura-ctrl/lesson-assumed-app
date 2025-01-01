package com.example.lesson_assumed_app.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteRepository {
    private final JdbcTemplate jdbcTemplate;

    public DeleteRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int deleteLesson(int id){
        String sql = "DELETE FROM history WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
