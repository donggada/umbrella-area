package com.example.umbrellaarea.umbrellaarea.admin.controller;

import com.example.umbrellaarea.umbrellaarea.admin.dto.SaveUmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.admin.service.AdminUmbrellaZoneService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone.UmbrellaZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminSaveController {

    private final AdminUmbrellaZoneService adminUmbrellaZoneService;

    @PostMapping("/umbrellaZone")
    public String saveUmbrellaZone (SaveUmbrellaZone saveUmbrellaZone) {
        adminUmbrellaZoneService.saveUmbrellaZone(saveUmbrellaZone);
        return "redirect:/view/admin/map";
    }
}
