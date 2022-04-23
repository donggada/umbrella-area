package com.example.umbrellaarea.umbrellaarea.admin.service;

import com.example.umbrellaarea.umbrellaarea.admin.dto.SaveUmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UmbrellaZoneSettingServiceImplTest {

    @Autowired
    UmbrellaZoneRepository umbrellaZoneRepository;
    @Autowired
    UmbrellaRepository umbrellaRepository;

     @Test
         public void saveUmbrellaZoneSetting(){
             //given
         SaveUmbrellaZone umbrellaZoneSetting = SaveUmbrellaZone.builder()
                 .umbrellaCount(10)
                 .nx(30.2)
                 .ny(149.4)
                 .zoneName("TEST ZONE")
                 .build();
         //when
         AdminUmbrellaZoneServiceImpl umbrellaZoneSettingService = new AdminUmbrellaZoneServiceImpl(umbrellaZoneRepository,umbrellaRepository);
         Long umbrellaZoneId = umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);

         //then
         Assertions.assertThat(umbrellaZoneId).isNotNull();

         }

}