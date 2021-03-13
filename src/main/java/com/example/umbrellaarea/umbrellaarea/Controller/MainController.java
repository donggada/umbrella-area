package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.MyOrderDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Service.MapService;
import com.example.umbrellaarea.umbrellaarea.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Queue;

@Controller
public class MainController {
    @Autowired
    MapService mapService;


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
        return "adminmap";
    }



}
