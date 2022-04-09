package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Repository.Member;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryQueryDSL {

}
