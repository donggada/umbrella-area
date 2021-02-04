package com.example.umbrellaarea.umbrellaarea.DTO;

import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import lombok.Data;

@Data
public class UmbrellaAreaDTO {

    private Long id;
    private String name;
    private double nx;
    private double ny;
    private Long count;

    public UmbrellaAreaDTO(UmbrellaArea umbrellaArea) {
        this.id = umbrellaArea.getId();
        this.name = umbrellaArea.getName();
        this.nx = umbrellaArea.getNx();
        this.ny = umbrellaArea.getNy();
    }

    public UmbrellaAreaDTO() {

    }
}
