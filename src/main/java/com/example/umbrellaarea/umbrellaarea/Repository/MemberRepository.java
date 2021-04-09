package com.example.umbrellaarea.umbrellaarea.Repository;

import com.example.umbrellaarea.umbrellaarea.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByIdAndPass(String id,String pass);
    Member findById(String id);
}
