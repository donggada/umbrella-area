package com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmbrellaRepository extends JpaRepository<Umbrella, Long> {

    List<Umbrella> findByUmbrellaZoneIdAndState(Long UmbrellaZoneId, Boolean state);

}
