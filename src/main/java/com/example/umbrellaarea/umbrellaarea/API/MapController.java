package com.example.umbrellaarea.umbrellaarea.API;

import com.example.umbrellaarea.umbrellaarea.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {
    @Autowired
    MapService mapService;


}
