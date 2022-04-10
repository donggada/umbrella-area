package com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Member;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryQueryDSL {

}
