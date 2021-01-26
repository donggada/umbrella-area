package com.example.umbrellaarea.umbrellaarea.DTO;

import lombok.Data;

@Data
public class WeatherDTO {
    private String local;
    private String LGT; //낙뢰
    private String T1H; //기온
    private String SKY; //구름
    private String PTY; //강수량
    private String date; //날짜

    public WeatherDTO(String LGT, String t1H, String SKY, String PTY) {
        this.LGT = LGT;
        this.T1H = t1H;
        this.SKY = SKY;
        this.PTY = PTY;
    }

    public WeatherDTO() {
        this.LGT = LGT;
    }
}
