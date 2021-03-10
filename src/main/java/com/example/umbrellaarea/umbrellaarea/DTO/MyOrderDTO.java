package com.example.umbrellaarea.umbrellaarea.DTO;

import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class MyOrderDTO {
    private Long id;
    private boolean state;
    private UmbrellaArea umbrellaArea;
    private Timestamp date;
    private String QR;

    public MyOrderDTO(Umbrella umbrella,boolean state) {
        this.id = umbrella.getId();
        this.state = state;
        this.umbrellaArea = umbrella.getUmbrellaArea();
        this.date = umbrella.getDate();
    }

    public MyOrderDTO() {

    }
}
