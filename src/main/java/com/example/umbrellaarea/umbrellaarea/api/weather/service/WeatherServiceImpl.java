package com.example.umbrellaarea.umbrellaarea.api.weather.service;


import com.example.umbrellaarea.umbrellaarea.api.weather.response.Weather;
import com.example.umbrellaarea.umbrellaarea.Enum.WeatherLocal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WeatherServiceImpl implements WeatherService {

    // 맑음, 비 , 번개 , 우박
    private static final String[] weatherType = {"sunny", "rain", "storm", "drizzle"};

    Random random = new Random();
    @Override
    public List<Weather> makeLocalWeather() {
        List<Weather> weatherList = new ArrayList<>();
        WeatherLocal[] weatherLocal = WeatherLocal.values();

        for (WeatherLocal local : weatherLocal) {
            Weather weather = Weather.createWeather(local.getDescription(), makeRandomWeatherType(), makeRandomTemperatures());
            weatherList.add(weather);
        }

        System.out.println(weatherList.toString());
        return weatherList;
    }

    private Integer makeRandomTemperatures () {
        return random.nextInt(33);
    }

    private String makeRandomWeatherType () {
        return weatherType[random.nextInt(weatherType.length)];
    }
}


