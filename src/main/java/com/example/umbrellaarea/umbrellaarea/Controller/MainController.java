package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Service.MapService;
import com.example.umbrellaarea.umbrellaarea.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    MapService mapService;

    //메인 화면
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("/map")
    public String map(){
        return "map";
    }

    @RequestMapping("/order/{id}")
    public String order(@PathVariable (name = "id") Long id, Model model){

        if(id!=0){
            model.addAttribute("areainfo",mapService.orderinfo(id));
        }else{
            model.addAttribute("areainfo","현재위치 ");
        }
        System.out.println();
        return "order";
    }

    @PostMapping("/order")
    public String postorder(Long id){
        System.out.println(id);

        return "map";
    }
}
