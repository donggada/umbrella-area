package com.example.umbrellaarea.umbrellaarea.admin.service;
import com.example.umbrellaarea.umbrellaarea.admin.request.UmbrellaZoneSetting;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UmbrellaZoneSettingServiceImpl implements UmbrellaZoneSettingService {

    private final UmbrellaZoneRepository umbrellaZoneRepository;

    private final UmbrellaRepository umbrellaRepository;

    @Override
    public UmbrellaZone saveUmbrellaZone(UmbrellaZoneSetting umbrellaZoneSetting) {

        UmbrellaZone saveUmbrellaZone = umbrellaZoneRepository
                .save(UmbrellaZone.createUmbrellaZone(umbrellaZoneSetting.getZoneName(),
                                                      umbrellaZoneSetting.getNx(),
                                                      umbrellaZoneSetting.getNy()));

        bulkSaveUmbrella(saveUmbrellaZone, umbrellaZoneSetting.getUmbrellaCount());

        return saveUmbrellaZone;
    }

    private void bulkSaveUmbrella(UmbrellaZone umbrellaZone, int saveCount) {
        for (int i = 0; i <saveCount ; i++) {
            umbrellaRepository.save(Umbrella.createUmbrella(umbrellaZone));
        }
    }
}
