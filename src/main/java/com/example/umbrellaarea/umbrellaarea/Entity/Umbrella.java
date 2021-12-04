package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.Umbrella.SaveUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.DTO.Umbrella.UseUmbrellaDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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

    public void useUmbrella (boolean state) {
        this.state = state;
    }

    public void returnUmbrella (UmbrellaZone umbrellaZone, boolean state) {
        this.umbrellaZone = umbrellaZone;
        this.state = state;
    }
}
