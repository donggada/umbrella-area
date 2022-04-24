package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UmbrellaService {

    private final UmbrellaRepository umbrellaRepository;

    private final UmbrellaZoneRepository umbrellaZoneRepository;

    @Transactional
    public Umbrella borrowUmbrella(Long umbrellaId) {
        Umbrella umbrella = umbrellaRepository.findById(umbrellaId).orElseThrow(() -> new IllegalArgumentException("우산 없음"));
        umbrella.useUmbrella();
        return umbrella;
    }

    @Transactional
    public Umbrella returnUmbrella(Long umbrellaZoneId, Long umbrellaId) {
        Umbrella umbrella = umbrellaRepository.findById(umbrellaId).orElseThrow(() -> new IllegalArgumentException("우산 없음"));
        UmbrellaZone umbrellaZone = umbrellaZoneRepository.findById(umbrellaZoneId).orElseThrow(() -> new IllegalArgumentException("우산 대여존 없음"));
        umbrella.returnUmbrella(umbrellaZone);
        return umbrella;
    }
}
