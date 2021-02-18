package com.example.umbrellaarea.umbrellaarea.DTO;

import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UmbrellaDTO {
    private Long id;
    private boolean state;
    private UmbrellaArea umbrellaArea;
    private Timestamp date=new Timestamp(System.currentTimeMillis());

    public UmbrellaDTO(Umbrella umbrella) {
        this.id = umbrella.getId();
        this.state = umbrella.isState();
        this.umbrellaArea = umbrella.getUmbrellaArea();
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public UmbrellaDTO(Umbrella umbrella,boolean state) {
        this.id = umbrella.getId();
        this.state = state;
        this.umbrellaArea = umbrella.getUmbrellaArea();
        this.date = umbrella.getDate();
    }

    public UmbrellaDTO() {
    }
}
