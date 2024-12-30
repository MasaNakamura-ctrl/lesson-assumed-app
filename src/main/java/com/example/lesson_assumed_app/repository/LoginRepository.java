package com.example.lesson_assumed_app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
    // 調節PostgreSQLにクエリを実行させる
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    public boolean existsByKeys(String userid, String confirmword){
        String sql = "SELECT COUNT(*) FROM users WHERE userid = ? AND confirmword = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{userid, confirmword}, Integer.class);
        return count != null && count > 0;
    }
}
