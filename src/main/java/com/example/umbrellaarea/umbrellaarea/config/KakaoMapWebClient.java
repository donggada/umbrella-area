package com.example.umbrellaarea.umbrellaarea.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

//@Configuration
public class KakaoMapWebClient {

    @Value("${kakao.map.rest.api.key}")
    private String secretKey;

    @Bean
    public WebClient kakaoMapWebClient() {

        return WebClient.builder().build();
    }
}
