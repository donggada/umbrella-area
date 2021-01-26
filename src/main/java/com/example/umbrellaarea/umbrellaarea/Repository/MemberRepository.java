package com.example.umbrellaarea.umbrellaarea.Repository;

import com.example.umbrellaarea.umbrellaarea.DTO.MemberDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query(value = "select m from member m where m.member_id = :#{#member.member_id} and m.member_pass = :#{#member.member_pass}")
    Member findById(Member member);
}
