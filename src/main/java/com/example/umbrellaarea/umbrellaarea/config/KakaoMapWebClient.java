package com.example.umbrellaarea.umbrellaarea.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

//@Configuration
public class KakaoMapWebClient {

//    @Value("${kakao.secret.key}")
//    private String secretKey;

    @Bean
    public WebClient kakaoMapWebClient() {

        return WebClient.builder().build();
    }
}
