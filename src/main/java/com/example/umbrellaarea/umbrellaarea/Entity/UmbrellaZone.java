package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaZone.ModifyUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaZone.SaveUmbrellaZoneDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class UmbrellaZone extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double nx;

    private double ny;

    private String adders;

    public UmbrellaZone (SaveUmbrellaZoneDto saveUmbrellaZoneDto) {
        this.name = saveUmbrellaZoneDto.getName();
        this.nx = saveUmbrellaZoneDto.getNx();
        this.ny = saveUmbrellaZoneDto.getNy();
        this.adders = saveUmbrellaZoneDto.getAdders();
    }

    public void modifyUmbrellaZone (ModifyUmbrellaZoneDto modifyUmbrellaZoneDto) {
        this.name = modifyUmbrellaZoneDto.getName();
        this.nx = modifyUmbrellaZoneDto.getNx();
        this.ny = modifyUmbrellaZoneDto.getNy();
        this.adders = modifyUmbrellaZoneDto.getAdders();
    }

}
