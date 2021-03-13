package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.MyOrderDTO;
import com.example.umbrellaarea.umbrellaarea.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    MapService mapService;
    //주문페이지
    @RequestMapping("/order/{id}")
    public String order(@PathVariable(name = "id") Long id, Model model){

        if(id!=0){
            model.addAttribute("areainfo",mapService.orderinfo(id));
        }else{
            model.addAttribute("areainfo","현재위치 ");
        }
        return "order";
    }
    //주문 작업 수행 (아아디 값 넣기)
    @PostMapping("/order")
    public String postorder(Long id,Model model){

        MyOrderDTO myOrderDTO =mapService.order(id);
        if(myOrderDTO!=null) {
            model.addAttribute("umbrella", myOrderDTO);
        }
        return "myorder";
    }
    //내가 주문한 정보(test)
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
