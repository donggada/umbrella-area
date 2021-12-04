package com.example.umbrellaarea.umbrellaarea.DTO.Member;

import lombok.Data;

import javax.persistence.Column;
@Data
public class SaveMemberDto {
    private String memberId;
    private String memberPass;
    private String memberName;
    private String birthDay;
    private String gender;
}
