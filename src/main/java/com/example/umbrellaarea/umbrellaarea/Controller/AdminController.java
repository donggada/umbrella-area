package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    //대여존 초기 설정
    @RequestMapping("/areainit")
    public String areainit(UmbrellaAreaDTO umbrellaAreaDTO, Model model){
        model.addAttribute("lat",umbrellaAreaDTO);
        return "umbrellaAreainit";
    }
}
