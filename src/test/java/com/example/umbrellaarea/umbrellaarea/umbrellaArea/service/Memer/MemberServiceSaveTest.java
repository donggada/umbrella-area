package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Memer;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.Member.SaveMemberDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Member;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Member.MemberRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class MemberServiceSaveTest {

    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

     @Test
         public void saveMember(){
         String memberId = "test";
         String memberPass = "1234";
         String memberName = "홍길동";
         String memberGender = "남";
         String memberBirthDay = "940425";

         //given
         SaveMemberDto saveMemberDto = new SaveMemberDto();
         saveMemberDto.setMemberId(memberId);
         saveMemberDto.setMemberPass(memberPass);
         saveMemberDto.setMemberName(memberName);
         saveMemberDto.setGender(memberGender);
         saveMemberDto.setBirthDay(memberBirthDay);

         //when
         Member member = memberService.saveMember(saveMemberDto);

         //then

         ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass(Member.class);
         Member save = Mockito.verify(memberRepository, Mockito.times(1)).save(memberArgumentCaptor.capture());
         assertThat(memberArgumentCaptor.getValue().getMemberId()).isEqualTo(memberId);
         assertThat(memberArgumentCaptor.getValue().getMemberPass()).isEqualTo(memberPass);
         assertThat(memberArgumentCaptor.getValue().getMemberName()).isEqualTo(memberName);
         assertThat(memberArgumentCaptor.getValue().getGender()).isEqualTo(memberGender);
         assertThat(memberArgumentCaptor.getValue().getBirthDay()).isEqualTo(memberBirthDay);
     }
}