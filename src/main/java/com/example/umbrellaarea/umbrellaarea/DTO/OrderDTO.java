package com.example.umbrellaarea.umbrellaarea.DTO;

import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import com.example.umbrellaarea.umbrellaarea.Entity.Orders;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import lombok.Data;

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

    public OrderDTO(Orders orders) {
        this.id = orders.getId();
        this.umbrella = orders.getUmbrella();
        this.QR = orders.getQR();
        this.member = orders.getMember();
    }
}
