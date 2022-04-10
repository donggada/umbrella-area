package com.example.umbrellaarea.umbrellaarea.api.weather.service;

import com.example.umbrellaarea.umbrellaarea.api.weather.response.Weather;

import com.example.umbrellaarea.umbrellaarea.Enum.WeatherLocal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class WeatherServiceImplTest {

     @Test
         public void makeWeatherList() {
         //given
         WeatherServiceImpl weatherService = new WeatherServiceImpl();
         //when
         List<Weather> weathers = weatherService.makeLocalWeather();
         //then
         Assertions.assertThat(weathers.size()).isEqualTo(WeatherLocal.values().length);
     }

}