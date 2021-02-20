package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long num;
    @Column(unique = true)
    private String id;
    private String name;
    private String pass;
    private String bir_Y;
    private String bir_M;
    private String bir_D;
    private String gender;

    public Member() {
    }

    public Member(MemberDTO memberDTO) {
        this.num = memberDTO.getMember_num();
        this.id = memberDTO.getMember_id();
        this.name = memberDTO.getMember_name();
        this.pass = memberDTO.getMember_pass();
        this.bir_Y = memberDTO.getMember_bir_Y();
        this.bir_M = memberDTO.getMember_bir_M();
        this.bir_D = memberDTO.getMember_bir_D();
        this.gender = memberDTO.getMember_gender();
    }
}
