package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.Umbrella.ReturnUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.Umbrella.SaveUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.Umbrella.UseUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UmbrellaService {
    private final UmbrellaRepository umbrellaRepository;
    private final UmbrellaZoneRepository umbrellaZoneRepository;

    public boolean saveUmbrella(SaveUmbrellaDto saveUmbrellaDto) {
        //TODO  옵셔널 처리
        UmbrellaZone findUmbrellaZone = umbrellaZoneRepository.findById(saveUmbrellaDto.getUmbrellaZoneId()).get();
        Umbrella umbrella = new Umbrella(findUmbrellaZone, false);
        return umbrellaRepository.save(umbrella).getId() != null;
    }

    public boolean useUmbrella (UseUmbrellaDto useUmbrellaDto) {
        //TODO  옵셔널 처리
        Umbrella findUmbrella = umbrellaRepository.findById(useUmbrellaDto.getId()).get();
        findUmbrella.useUmbrella(true);
        return true;
    }


    public boolean returnUmbrella (ReturnUmbrellaDto returnUmbrellaDto) {
        //TODO  옵셔널 처리
        Umbrella findUmbrella = umbrellaRepository.findById(returnUmbrellaDto.getId()).get();
        UmbrellaZone findUmbrellaZone = umbrellaZoneRepository.findById(returnUmbrellaDto.getUmbrellaZoneId()).get();

        findUmbrella.returnUmbrella(findUmbrellaZone, false);
        return true;
    }
}
