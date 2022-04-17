package com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class MapUmbrellaZoneDto {

    private String name;

    private double nx;

    private double ny;

    private String adders;

    private Integer count;

    @QueryProjection
    public MapUmbrellaZoneDto(String name, double nx, double ny, String adders, Integer count) {
        this.name = name;
        this.nx = nx;
        this.ny = ny;
        this.adders = adders;
        this.count = count;
    }
}
