package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@Getter
public class Umbrella {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "umbrella_area_id")
    private UmbrellaArea umbrellaArea;
    private boolean state;
    private Timestamp date;

    public Umbrella(UmbrellaDTO umbrellaDTO) {
        this.id = umbrellaDTO.getId();
        this.date = umbrellaDTO.getDate();
        this.umbrellaArea = umbrellaDTO.getUmbrellaArea();
        this.state = true;
    }

    public Umbrella() {

    }
}
