package com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.Member;

import lombok.Data;

@Data
public class SaveMemberDto {
    private String memberId;
    private String memberPass;
    private String memberName;
    private String birthDay;
    private String gender;
}
