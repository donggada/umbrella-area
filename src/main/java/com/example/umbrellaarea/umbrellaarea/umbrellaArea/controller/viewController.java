package com.example.umbrellaarea.umbrellaarea.umbrellaArea.controller;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Umbrella.UmbrellaService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone.UmbrellaZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class viewController {

    @Value("${kakao.map.sdk.js.url}")
    private String kakaoMapSdkUrl;

    private final UmbrellaZoneRepository umbrellaZoneRepository;

    private final UmbrellaRepository umbrellaRepository;

    private final UmbrellaZoneService umbrellaZoneService;

    private final UmbrellaService umbrellaService;

    @GetMapping("/view/map")
    public String viewKakaoMap (Model model) {
        model.addAttribute("kakaoMapUrl", kakaoMapSdkUrl);
        return "map";
    }

    @GetMapping("/view/umbrellaZone/{id}")
    public String viewUmbrellaZone (Model model, @PathVariable("id") Long id) {
        MapUmbrellaZoneDto umbrellaZoneDto = umbrellaZoneService.selectDetailUmbrellaZone(id);
        List<Umbrella> umbrellaList = umbrellaRepository.findByUmbrellaZoneIdAndState(id, false);
        model.addAttribute("umbrellaZoneDto", umbrellaZoneDto);
        model.addAttribute("umbrellaList", umbrellaList);
        return "Order/order";
    }

    @PostMapping("/view/borrowUmbrella/{id}")
    public String viewBorrowUmbrella (Model model, @PathVariable("id") Long id) {
        Umbrella umbrella = umbrellaService.borrowUmbrella(id);
        model.addAttribute("umbrella", umbrella);
        return "Order/resultBorrowUmbrella";
    }

}
