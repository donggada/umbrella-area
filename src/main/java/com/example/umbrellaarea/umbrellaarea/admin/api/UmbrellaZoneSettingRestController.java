package com.example.umbrellaarea.umbrellaarea.admin.api;

import com.example.umbrellaarea.umbrellaarea.admin.dto.UmbrellaZoneSetting;
import com.example.umbrellaarea.umbrellaarea.admin.service.UmbrellaZoneSettingService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UmbrellaZoneSettingRestController {

    private final UmbrellaZoneSettingService umbrellaZoneSettingService;

    @PostMapping("/api/umbrellaZone/setting")
    public UmbrellaZone saveUmbrellaZone (UmbrellaZoneSetting umbrellaZoneSetting) {
        return umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);
    }

}
