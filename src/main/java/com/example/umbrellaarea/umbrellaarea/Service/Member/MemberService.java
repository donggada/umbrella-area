package com.example.umbrellaarea.umbrellaarea.Service.Member;

import com.example.umbrellaarea.umbrellaarea.DTO.Member.SaveMemberDto;
import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import com.example.umbrellaarea.umbrellaarea.Repository.Member.MemberRepository;
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
        Member save = memberRepository.save(member);
        return save;
    }

}
