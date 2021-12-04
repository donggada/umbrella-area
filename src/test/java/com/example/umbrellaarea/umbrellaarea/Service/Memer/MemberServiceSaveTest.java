package com.example.umbrellaarea.umbrellaarea.Service.Memer;

import com.example.umbrellaarea.umbrellaarea.DTO.Member.SaveMemberDto;
import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import com.example.umbrellaarea.umbrellaarea.Repository.Member.MemberRepository;
import com.example.umbrellaarea.umbrellaarea.Service.Member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MemberServiceSaveTest {

//    @Mock
    @Autowired
    MemberRepository memberRepository;

//    @InjectMocks
    @Autowired
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
         System.out.println(member.toString());

         //then

//         ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass(Member.class);
//         Member save = Mockito.verify(memberRepository, Mockito.times(1)).save(memberArgumentCaptor.capture());
//         assertThat(memberArgumentCaptor.getValue().getMemberId()).isEqualTo(memberId);
//         assertThat(memberArgumentCaptor.getValue().getMemberPass()).isEqualTo(memberPass);
//         assertThat(memberArgumentCaptor.getValue().getMemberName()).isEqualTo(memberName);
//         assertThat(memberArgumentCaptor.getValue().getGender()).isEqualTo(memberGender);
//         assertThat(memberArgumentCaptor.getValue().getBirthDay()).isEqualTo(memberBirthDay);
     }
}