package com.example.umbrellaarea.umbrellaarea.admin.service;

import com.example.umbrellaarea.umbrellaarea.admin.dto.UmbrellaZoneSetting;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
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
         UmbrellaZoneSetting umbrellaZoneSetting = UmbrellaZoneSetting.builder()
                 .umbrellaCount(10)
                 .nx(30.2)
                 .ny(149.4)
                 .zoneName("TEST ZONE")
                 .build();
         //when
         UmbrellaZoneSettingServiceImpl umbrellaZoneSettingService = new UmbrellaZoneSettingServiceImpl(umbrellaZoneRepository,umbrellaRepository);
         UmbrellaZone umbrellaZone = umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);

         //then
         Assertions.assertThat(umbrellaZone).isNotNull();

         }

}