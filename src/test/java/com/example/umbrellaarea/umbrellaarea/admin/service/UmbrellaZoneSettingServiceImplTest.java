package com.example.umbrellaarea.umbrellaarea.admin.service;

import com.example.umbrellaarea.umbrellaarea.admin.request.UmbrellaZoneSetting;
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
         UmbrellaZoneSetting umbrellaZoneSetting = new UmbrellaZoneSetting();
         umbrellaZoneSetting.setUmbrellaCount(10);
         umbrellaZoneSetting.setNx(30.2);
         umbrellaZoneSetting.setNy(149.4);
         umbrellaZoneSetting.setZoneName("TEST ZONE");
         //when
         UmbrellaZoneSettingServiceImpl umbrellaZoneSettingService = new UmbrellaZoneSettingServiceImpl(umbrellaZoneRepository,umbrellaRepository);
         UmbrellaZone umbrellaZone = umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);

         //then
         Assertions.assertThat(umbrellaZone).isNotNull();

         }

}