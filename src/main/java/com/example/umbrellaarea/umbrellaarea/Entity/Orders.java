package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.OrderDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Umbrella umbrella;
    private String QR;
    @ManyToOne
    @JoinColumn(name = "member_num")
    private Member member;

    public Orders() {

    }

    public Orders(OrderDTO orderDTO) {
        this.umbrella=orderDTO.getUmbrella();
        this.QR=orderDTO.getQR();
        this.member=orderDTO.getMember();
    }

}
