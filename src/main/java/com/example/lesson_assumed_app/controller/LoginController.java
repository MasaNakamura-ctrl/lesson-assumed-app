package com.example.lesson_assumed_app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson_assumed_app.service.LoginService;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @PostMapping("/check")
    public String postIdPassword(
        // HTMLフォームの入力値を受け取る
        @RequestParam("userid") String userid,
        @RequestParam("confirmword") String confirmword,
        Model model){
        // サービスクラスにあるメソッドから組み合わせの確認を行う
        boolean exists = loginService.checkCombination(userid, confirmword);
        if (exists){
            // useridとconfirmwordの組み合わせが存在する場合記録一覧画面へ遷移
            return "redirect:/home";
        } else {
            // 存在しない場合エラーメッセージを表示した状態でログイン画面を再度表示
            model.addAttribute("error","ユーザーIDまたはパスワードが違います");
            return "login";
        }
    }
}
