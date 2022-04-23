package com.example.umbrellaarea.umbrellaarea.umbrellaArea.api.kakaoMap.controller;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UmbrellaZoneController {

    private final UmbrellaZoneQueryRepository umbrellaZoneQueryRepository;

    @GetMapping("/zone")
    public List<MapUmbrellaZoneDto> selectUmbrellaZone() {
        return umbrellaZoneQueryRepository.selectUmbrellaZone();
    }


}
