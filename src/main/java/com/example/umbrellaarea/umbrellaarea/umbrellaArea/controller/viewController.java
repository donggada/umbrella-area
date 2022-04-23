package com.example.umbrellaarea.umbrellaarea.umbrellaArea.controller;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone.UmbrellaZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class viewController {

    @Value("${kakao.map.sdk.js.url}")
    private String kakaoMapSdkUrl;

    private final UmbrellaZoneService umbrellaZoneService;

    @GetMapping("/view/map")
    public String viewKakaoMap (Model model) {
        model.addAttribute("kakaoMapUrl", kakaoMapSdkUrl);
        return "map";
    }

}
