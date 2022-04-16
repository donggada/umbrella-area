package com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@NoArgsConstructor
public class Umbrella extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private UmbrellaZone umbrellaZone;

    private boolean state;

    public Umbrella(UmbrellaZone umbrellaZone ,boolean state) {
        this.umbrellaZone = umbrellaZone;
        this.state = state;
    }

    public void useUmbrella () {
        this.state = false;
    }

    public void returnUmbrella (UmbrellaZone umbrellaZone) {
        this.umbrellaZone = umbrellaZone;
        this.state = true;
    }

    public static Umbrella createUmbrella (UmbrellaZone umbrellaZone) {
        return new Umbrella(umbrellaZone);
    }

    private Umbrella(UmbrellaZone umbrellaZone) {
        this.umbrellaZone = umbrellaZone;
        this.state = false;
    }
}
