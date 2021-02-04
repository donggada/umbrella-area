package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Umbrella {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long price;
    @ManyToOne
    @JoinColumn
    private UmbrellaArea umbrellaArea;
    private boolean state;

    public Umbrella(UmbrellaDTO umbrellaDTO) {
        this.id = umbrellaDTO.getId();
        this.price = umbrellaDTO.getPrice();
        this.umbrellaArea = umbrellaDTO.getUmbrellaArea();
        this.state = true;
    }

    public Umbrella() {

    }
}
