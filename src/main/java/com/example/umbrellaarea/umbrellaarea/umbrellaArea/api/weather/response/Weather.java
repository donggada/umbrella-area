package com.example.umbrellaarea.umbrellaarea.umbrellaArea.api.weather.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Weather {
    private String local;
    private String weatherType;
    private Integer temperatures;


    @Builder
    public static Weather createWeather(String local, String weatherType, Integer temperatures) {
        return new Weather(local, weatherType, temperatures);
    }


    private Weather(String local, String weatherType, Integer temperatures) {
        this.local = local;
        this.weatherType = weatherType;
        this.temperatures = temperatures;
    }
}
