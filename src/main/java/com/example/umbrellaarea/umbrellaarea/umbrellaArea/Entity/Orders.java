package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class Orders extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Umbrella umbrella;

    private String QR;

    @ManyToOne(fetch = LAZY)
    private Member member;




}
