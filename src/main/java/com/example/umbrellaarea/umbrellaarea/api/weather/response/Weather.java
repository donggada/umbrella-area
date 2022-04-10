package com.example.umbrellaarea.umbrellaarea.api.weather.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Weather {
    private String local;
    private String weatherType;
    private Integer temperatures;


    public static Weather createWeather(String local, String weatherType, Integer temperatures) {
        return new Weather(local, weatherType, temperatures);
    }

    private Weather(String local, String weatherType, Integer temperatures) {
        this.local = local;
        this.weatherType = weatherType;
        this.temperatures = temperatures;
    }
}
