package com.example.umbrellaarea.umbrellaarea.admin.controller;


import com.example.umbrellaarea.umbrellaarea.admin.dto.UmbrellaZoneSetting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminViewController {

    @Value("${kakao.map.sdk.js.url}")
    private String kakaoMapSdkUrl;

    @GetMapping("view/admin/map")
    public String viewAdminMap (Model model) {
        model.addAttribute("kakaoAdminMapUrl", kakaoMapSdkUrl + "&libraries=services");
        System.out.println(model.getAttribute("kakaoAdminMapUrl"));
        return "admin/adminMap";
    }

    @GetMapping("view/admin/umbrellaAreaInit")
    public String viewUmbrellaAreaInit (Model model, UmbrellaZoneSetting umbrellaZoneSetting) {
        model.addAttribute("UmbrellaZoneSetting",umbrellaZoneSetting);
        return "admin/umbrellaAreaInit";
    }


}
