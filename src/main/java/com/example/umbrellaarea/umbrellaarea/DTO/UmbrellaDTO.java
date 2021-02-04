package com.example.umbrellaarea.umbrellaarea.DTO;

import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import lombok.Data;

@Data
public class UmbrellaDTO {
    private Long id;
    private Long price;
    private boolean state;
    private UmbrellaArea umbrellaArea;
}
