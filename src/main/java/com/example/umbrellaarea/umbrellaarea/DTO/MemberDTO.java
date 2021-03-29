package com.example.umbrellaarea.umbrellaarea.DTO;

import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import lombok.Data;

@Data
public class MemberDTO {
    private long member_num;
    private String member_id;
    private String member_name;
    private String member_pass;
    private String member_bir_Y;
    private String member_bir_M;
    private String member_bir_D;
    private String member_gender;
    private boolean member_subscribe;

    public MemberDTO(Member member) {
        this.member_num = member.getNum();
        this.member_id = member.getId();
        this.member_name = member.getName();
        this.member_pass = member.getPass();
        this.member_bir_Y = member.getBir_Y();
        this.member_bir_M = member.getBir_M();
        this.member_bir_D = member.getBir_D();
        this.member_gender = member.getGender();
        this.member_subscribe=member.isSubscribe();
    }

    public MemberDTO() {
        this.member_num = member_num;
    }
}
