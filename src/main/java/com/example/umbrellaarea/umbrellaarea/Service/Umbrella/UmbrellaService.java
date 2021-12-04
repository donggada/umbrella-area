package com.example.umbrellaarea.umbrellaarea.Service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.DTO.Umbrella.ReturnUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.DTO.Umbrella.SaveUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.DTO.Umbrella.UseUmbrellaDto;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.Repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
