package com.example.umbrellaarea.umbrellaarea.admin.api;

import com.example.umbrellaarea.umbrellaarea.admin.dto.UmbrellaZoneSetting;
import com.example.umbrellaarea.umbrellaarea.admin.service.UmbrellaZoneSettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UmbrellaZoneSettingRestController {

    private final UmbrellaZoneSettingService umbrellaZoneSettingService;

    @PostMapping("/api/umbrellaZone/setting")
    public Object saveUmbrellaZone (@Valid UmbrellaZoneSetting umbrellaZoneSetting, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            log.error("No required parameters");
            log.error("umbrellaZoneSetting , {}", umbrellaZoneSetting);
            throw new Exception("No required parameters");
        }

        return umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);
    }

}
