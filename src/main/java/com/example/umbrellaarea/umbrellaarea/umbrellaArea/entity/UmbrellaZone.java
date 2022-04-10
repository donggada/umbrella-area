package com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.ModifyUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.SaveUmbrellaZoneDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class UmbrellaZone extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double nx;

    private double ny;

    private String adders;

    public static UmbrellaZone createUmbrellaZone (String name, double nx, double ny) {
       return new UmbrellaZone(name, nx, ny);
    }


    private UmbrellaZone(String name, double nx, double ny) {
        this.name = name;
        this.nx = nx;
        this.ny = ny;
    }
}
