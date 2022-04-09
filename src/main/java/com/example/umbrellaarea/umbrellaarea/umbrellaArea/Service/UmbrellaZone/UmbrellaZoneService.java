package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Service.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.UmbrellaZone.ModifyUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.UmbrellaZone.SaveUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
