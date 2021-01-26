package com.example.umbrellaarea.umbrellaarea.Entity;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "member")
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long member_num;
    @Column(unique = true)
    private String member_id;
    private String member_name;
    private String member_pass;
    private String member_bir_Y;
    private String member_bir_M;
    private String member_bir_D;
    private String member_gender;

    public Member() {
    }

    public Member(MemberDTO memberDTO) {
        this.member_num = memberDTO.getMember_num();
        this.member_id = memberDTO.getMember_id();
        this.member_name = memberDTO.getMember_name();
        this.member_pass = memberDTO.getMember_pass();
        this.member_bir_Y = memberDTO.getMember_bir_Y();
        this.member_bir_M = memberDTO.getMember_bir_M();
        this.member_bir_D = memberDTO.getMember_bir_D();
        this.member_gender = memberDTO.getMember_gender();
    }
}
