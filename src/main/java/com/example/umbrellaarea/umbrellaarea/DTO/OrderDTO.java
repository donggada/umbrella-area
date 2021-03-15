package com.example.umbrellaarea.umbrellaarea.DTO;

import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDTO {
    private Long id;
    private Umbrella umbrella;
    private String QR;
    private Member member;

    public OrderDTO(Umbrella umbrella) {

    }

    public OrderDTO(Umbrella umbrella, Member member) {
        this.umbrella=umbrella;
        this.member=member;
    }
}
