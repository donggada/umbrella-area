package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Service.Member;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.Member.SaveMemberDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity.Member;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member saveMember (SaveMemberDto saveMemberDto) {
        Member member = new Member(saveMemberDto);
        return memberRepository.save(member);
    }

}
