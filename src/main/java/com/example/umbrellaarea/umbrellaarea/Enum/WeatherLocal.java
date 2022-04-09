package com.example.umbrellaarea.umbrellaarea.Enum;

public enum WeatherLocal {
    Seoul               ("서울"),
    GyeonggiDo          ("경기도"),
    GangwonDo           ("강원도"),
    ChungCheongBukdo    ("충청북도"),
    ChungCheongNamDo    ("충청남도"),
    GyeongSangBukDo     ("경상북도"),
    GyeongSangNamDo     ("경상남도"),
    JeolLaNamDo         ("전라남도"),
    JeolLaBukDo         ("전라북도"),
    JejuIsland          ("제주도");

    private  final  String description;

    WeatherLocal(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
