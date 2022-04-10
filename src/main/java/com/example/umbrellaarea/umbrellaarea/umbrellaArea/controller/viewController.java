package com.example.umbrellaarea.umbrellaarea.umbrellaArea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {

    @Value("${kakao.map.sdk.js.url}")
    private String kakaoMapSdkUrl;

    @GetMapping("/view/map")
    public String viewKakaoMap (Model model) {
        model.addAttribute("kakaoMapUrl", kakaoMapSdkUrl);
        return "map";
    }
}
