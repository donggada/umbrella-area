package com.example.umbrellaarea.umbrellaarea.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    //메인 화면
    @RequestMapping("/")
    public String main(){
        return "index";
    }
    //로그인 화면
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //회원가입 화면
    @RequestMapping("/join")
    public String join(){
        return "join";
    }
    @RequestMapping("/join1")
    public String join1(){
        return "JoinForm";
    }

}
