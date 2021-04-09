package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class UmbrellaArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double nx;
    private double ny;

    public UmbrellaArea(UmbrellaAreaDTO umbrellaAreaDTO) {
        this.id = umbrellaAreaDTO.getId();
        this.name = umbrellaAreaDTO.getName();
        this.nx = umbrellaAreaDTO.getNx();
        this.ny = umbrellaAreaDTO.getNy();
    }

    public UmbrellaArea() {
    }
}
