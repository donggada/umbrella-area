package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.Meg;
import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import com.example.umbrellaarea.umbrellaarea.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    //로그인 화면
    @RequestMapping("/login")
    public String login() {
        return "/Member/login";
    }

    //회원가입 화면
    @RequestMapping("/join")
    public String join() {
        return "/Member/join";
    }

    //회원등록
    @PostMapping("join")
    public String joinpost(MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "login";
    }
    //로그인
    @PostMapping("login")
    public String loginpost(MemberDTO memberDTO, HttpSession session, Model model){
       Member member=memberService.find(memberDTO);
       if(member!=null){
           session.setAttribute("member",new MemberDTO(member));
           return "/";
       }else{
           return "/";
       }

    }
}
