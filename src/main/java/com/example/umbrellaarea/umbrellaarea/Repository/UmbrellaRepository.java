package com.example.umbrellaarea.umbrellaarea.Repository;

import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UmbrellaRepository extends JpaRepository<Umbrella,Long> {
    Long countByUmbrellaArea(UmbrellaArea umbrellaArea);

    List<Umbrella> findByUmbrellaArea_Id(Long id);
}
