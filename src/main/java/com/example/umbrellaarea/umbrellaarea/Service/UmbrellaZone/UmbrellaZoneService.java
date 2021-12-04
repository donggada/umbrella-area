package com.example.umbrellaarea.umbrellaarea.Service.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaZone.ModifyUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaZone.SaveUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UmbrellaZoneService {
    private final UmbrellaZoneRepository umbrellaZoneRepository;

    public boolean saveUmbrellaZone (SaveUmbrellaZoneDto saveUmbrellaZoneDto) {
        UmbrellaZone umbrellaZone = new UmbrellaZone(saveUmbrellaZoneDto);
        UmbrellaZone member = umbrellaZoneRepository.save(umbrellaZone);
        return member.getId() != null;
    }


    public boolean modifyUmbrellaZone (Long umbrellaZoneId, ModifyUmbrellaZoneDto modifyUmbrellaZoneDto) {
        //todo 옵셔널 처리
        UmbrellaZone findUmbrellaZone = umbrellaZoneRepository.findById(umbrellaZoneId).get();
        findUmbrellaZone.modifyUmbrellaZone(modifyUmbrellaZoneDto);
        return true;
    }

}
