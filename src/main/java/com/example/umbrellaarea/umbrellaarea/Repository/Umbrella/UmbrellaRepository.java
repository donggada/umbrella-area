package com.example.umbrellaarea.umbrellaarea.Repository.Umbrella;

import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmbrellaRepository extends JpaRepository<Umbrella, Long> {

}
