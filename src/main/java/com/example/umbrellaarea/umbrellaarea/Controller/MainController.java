package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    //메인 화면
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    //지도 화면
    @RequestMapping("/map")
    public String map(){
        return "map";
    }

    //관리자 페이지
    @RequestMapping("/adminmap")
    public String adminmap(){
        return "/Admin/adminmap";
    }



}
