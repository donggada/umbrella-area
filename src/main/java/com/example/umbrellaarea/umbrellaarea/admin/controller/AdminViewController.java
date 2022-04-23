package com.example.umbrellaarea.umbrellaarea.admin.controller;


import com.example.umbrellaarea.umbrellaarea.admin.dto.ViewUmbrellaZone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view/admin")
public class AdminViewController {

    @Value("${kakao.map.sdk.js.url}")
    private String kakaoMapSdkUrl;

    @GetMapping("/map")
    public String viewAdminMap (Model model) {
        model.addAttribute("kakaoAdminMapUrl", kakaoMapSdkUrl + "&libraries=services");
        return "admin/map";
    }

    @GetMapping("/umbrellaZone")
    public String viewUmbrellaAreaInit (Model model, ViewUmbrellaZone viewUmbrellaZone) {
        model.addAttribute("viewUmbrellaZone", viewUmbrellaZone);
        return "admin/umbrellaZone";
    }

}
