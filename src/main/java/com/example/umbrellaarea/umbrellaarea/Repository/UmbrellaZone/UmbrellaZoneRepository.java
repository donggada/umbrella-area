package com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmbrellaZoneRepository extends JpaRepository<UmbrellaZone, Long> {

}
