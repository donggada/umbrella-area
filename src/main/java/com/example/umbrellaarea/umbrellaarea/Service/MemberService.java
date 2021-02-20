package com.example.umbrellaarea.umbrellaarea.Service;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import com.example.umbrellaarea.umbrellaarea.Repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        Member member=new Member(memberDTO);
        memberRepository.save(member);
    }

    public Member find(MemberDTO memberDTO) {
        Member member=new Member(memberDTO);
        return memberRepository.findByIdAndPass(memberDTO.getMember_id(),memberDTO.getMember_pass());
    }



}
