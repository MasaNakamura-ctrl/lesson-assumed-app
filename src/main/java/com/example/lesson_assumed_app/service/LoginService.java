package com.example.lesson_assumed_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson_assumed_app.repository.LoginRepository;

@Service
public class LoginService {
    // Repository層を呼び出し組み合わせの存在確認を実施
    @Autowired
    private LoginRepository loginRepository;

    public boolean checkCombination(String userid, String confirmword){
        return loginRepository.existsByKeys(userid, confirmword);
    }
}
