package com.example.umbrellaarea.umbrellaarea.Repository;

import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UmbrellaRepository extends JpaRepository<Umbrella,Long> {
    Long countByUmbrellaArea(UmbrellaArea umbrellaArea);
}
