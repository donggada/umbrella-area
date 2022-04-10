package com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class PayHist extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Member member;
}
