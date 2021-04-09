package com.example.umbrellaarea.umbrellaarea.Controller;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.OrderDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Orders;
import com.example.umbrellaarea.umbrellaarea.Repository.OrderRepository;
import com.example.umbrellaarea.umbrellaarea.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    //주문페이지(아디디 x ,대여존 id o)  order/{아이디 id}/{대여존 id}
    @RequestMapping("/order/{id}")
    public String order(@PathVariable(name = "id") Long id, Model model){

        if(id!=0){
            model.addAttribute("areainfo",orderService.orderinfo(id));
        }else{
            model.addAttribute("areainfo","현재위치 ");
        }
        return "/Order/order";
    }
    //주문 작업 수행 (아이디 x) (아아디 값 넣기) order/{아이디 id}/
    @PostMapping("/order")
    public String postorder(Long id, String member_id, Model model){

        Orders order =orderService.order(id,member_id);
        if(order!=null) {
            model.addAttribute("order", order);
        }
        return "/Order/myorder";
    }
    //내가 주문한 정보(test) (아이디 x ,주문 x)  order/{아이디 id}/{주문 id}
    @GetMapping("/myorder/{member_id}/{id}")
    public String  myorder(@PathVariable(name = "id") Long id,@PathVariable(name = "member_id")String member_id,Model model){
        OrderDTO order =orderService.myorder(id);
        System.out.println(id);
        if(order!=null) {
            model.addAttribute("myorder", order);
        }
        return "ttttttt";
    }

}
