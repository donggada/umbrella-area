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

    @RequestMapping("/adminmap")
    public String adminmap(){
        return "adminmap";
    }
    @RequestMapping("/areainit")
    public String areainit(UmbrellaAreaDTO umbrellaAreaDTO,Model model){
        model.addAttribute("lat",umbrellaAreaDTO);
        return "umbrellaAreainit";
    }


    @RequestMapping("/order/{id}")
    public String order(@PathVariable (name = "id") Long id, Model model){

        if(id!=0){
            model.addAttribute("areainfo",mapService.orderinfo(id));
        }else{
            model.addAttribute("areainfo","현재위치 ");
        }
        return "order";
    }

    @PostMapping("/order")
    public String postorder(Long id,Model model){

        MyOrderDTO myOrderDTO =mapService.order(id);
        if(myOrderDTO!=null) {
            model.addAttribute("umbrella", myOrderDTO);
        }
        return "myorder";
    }

    @GetMapping("/myorder/{id}")
    public String  myorder(@PathVariable(name = "id") Long id,Model model){

        MyOrderDTO myOrderDTO =mapService.order(id);
        System.out.println(id);
        myOrderDTO.setQR("/QRCode/memberid_81");
        if(myOrderDTO!=null) {
            model.addAttribute("umbrella", myOrderDTO);
        }
        return "ttttttt";

    }

}
