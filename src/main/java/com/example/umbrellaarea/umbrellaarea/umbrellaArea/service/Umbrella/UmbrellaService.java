package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
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
    public Umbrella borrowUmbrella(Long umbrellaId) throws Exception {
        Umbrella umbrella = umbrellaRepository.findById(umbrellaId).orElseThrow(() -> new Exception("값 없음"));
        umbrella.useUmbrella(false);
        return umbrella;
    }
}
