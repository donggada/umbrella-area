package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UmbrellaZoneService {

    private final UmbrellaZoneQueryRepository umbrellaZoneQueryRepository;

    public List<MapUmbrellaZoneDto> selectUmbrellaZoneAndUmbrellaCount() {
       return umbrellaZoneQueryRepository.selectUmbrellaZone();
    }

    public MapUmbrellaZoneDto selectDetailUmbrellaZone(Long umbrellaZoneId) {
        return umbrellaZoneQueryRepository.selectDetailUmbrellaZone(umbrellaZoneId);
    }

}
