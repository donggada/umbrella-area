package com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MapUmbrellaZoneDto {

    private Long id;

    private String name;

    private double nx;

    private double ny;

    private String adders;

    private Long count;

    @QueryProjection
    public MapUmbrellaZoneDto(Long id ,String name, double nx, double ny, String adders, Long count) {
        this.id = id;
        this.name = name;
        this.nx = nx;
        this.ny = ny;
        this.adders = adders;
        this.count = count;
    }
}
