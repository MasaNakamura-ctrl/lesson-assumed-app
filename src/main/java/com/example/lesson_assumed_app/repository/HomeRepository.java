package com.example.lesson_assumed_app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.lesson_assumed_app.model.Lesson;


@Repository
public class HomeRepository {
    private final JdbcTemplate jdbcTemplate;

    public HomeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Lesson> findAll(){
        // Lessonにて全項目を取得できるようhome.htmlで表示しないカラム"lessonMemo"も取得
        String sql = "SELECT * FROM history ORDER BY id";
        return jdbcTemplate.query(sql, new HomeRowMapper());
    }

    private static class HomeRowMapper implements RowMapper<Lesson>{
        @SuppressWarnings("null")
        @Override
        public Lesson mapRow(ResultSet rs, int rowNum) throws SQLException{
            Lesson lesson = new Lesson();
            lesson.setId(rs.getInt("id"));
            lesson.setLessonDate(rs.getDate("lessonDate").toLocalDate());
            lesson.setStudentName(rs.getString("studentName"));
            return lesson;
        }
    }
}
