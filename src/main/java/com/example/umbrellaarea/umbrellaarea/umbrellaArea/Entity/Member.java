package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.Member.SaveMemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String memberId;
    private String memberPass;
    private String memberName;
    private String birthDay;
    private String gender;

    public Member(SaveMemberDto saveMemberDto) {
        this.memberId = saveMemberDto.getMemberId();
        this.memberPass = saveMemberDto.getMemberPass();
        this.memberName = saveMemberDto.getMemberName();
        this.birthDay = saveMemberDto.getBirthDay();
        this.gender = saveMemberDto.getGender();
    }


}
