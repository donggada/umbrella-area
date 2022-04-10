package com.example.umbrellaarea.umbrellaarea.api.weather.controller;

import com.example.umbrellaarea.umbrellaarea.api.weather.response.Weather;
import com.example.umbrellaarea.umbrellaarea.api.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/api/weather")
    public List<Weather> makeWeather () {
        return weatherService.makeLocalWeather();
    }


}
