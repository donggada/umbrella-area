package com.example.umbrellaarea.umbrellaarea.admin.service;
import com.example.umbrellaarea.umbrellaarea.admin.dto.SaveUmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUmbrellaZoneServiceImpl implements AdminUmbrellaZoneService {

    private final UmbrellaZoneRepository umbrellaZoneRepository;

    private final UmbrellaRepository umbrellaRepository;

    @Override
    public Long saveUmbrellaZone(SaveUmbrellaZone saveUmbrellaZone1) {

        UmbrellaZone saveUmbrellaZone = umbrellaZoneRepository.save(
                UmbrellaZone.createUmbrellaZone(
                        saveUmbrellaZone1.getZoneName(),
                        saveUmbrellaZone1.getNx(),
                        saveUmbrellaZone1.getNy()
                )
        );

        bulkSaveUmbrella(saveUmbrellaZone, saveUmbrellaZone1.getUmbrellaCount());
        return saveUmbrellaZone.getId();
    }

    private void bulkSaveUmbrella(UmbrellaZone umbrellaZone, int saveCount) {
        for (int i = 0; i <saveCount ; i++) {
            umbrellaRepository.save(Umbrella.createUmbrella(umbrellaZone));
        }
    }
}
