package com.example.umbrellaarea.umbrellaarea.API;

import com.example.umbrellaarea.umbrellaarea.DTO.WeatherDTO;
import com.example.umbrellaarea.umbrellaarea.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WeatherController {
    @Autowired
    WeatherService weatherService;


    @GetMapping("/weather")
    public ArrayList<WeatherDTO> weather(){
        return weatherService.weater();
    }

}
