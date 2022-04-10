package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Member;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.Member.SaveMemberDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Member;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Member.MemberRepository;
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
