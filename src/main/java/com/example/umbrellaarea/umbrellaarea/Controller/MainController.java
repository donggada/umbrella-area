package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import com.example.umbrellaarea.umbrellaarea.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //메인 화면
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("/map")
    public String map(){
        return "map";
    }
}
