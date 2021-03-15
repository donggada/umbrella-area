package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    //대여존 초기 설정
    @RequestMapping("/areainit")
    public String areainit(UmbrellaAreaDTO umbrellaAreaDTO, Model model){
        model.addAttribute("lat",umbrellaAreaDTO);
        return "/Admin/umbrellaAreainit";
    }
    @PostMapping("/umbrellafirst")
    public String umbrellafirst(UmbrellaAreaDTO umbrellaAreaDTO){
        adminService.sitting(umbrellaAreaDTO) ;
        return "redirect:/adminmap";
    }
}
