package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.admin.dto.UmbrellaZoneSetting;
import com.example.umbrellaarea.umbrellaarea.admin.service.UmbrellaZoneSettingService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneQueryRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UmbrellaZoneServiceTest {

    @Autowired
    UmbrellaZoneService umbrellaZoneService;

    @Autowired
    UmbrellaZoneRepository umbrellaZoneRepository;

    @Autowired
    UmbrellaZoneSettingService umbrellaZoneSettingService;


    @BeforeEach
    void  init () {
        UmbrellaZoneSetting umbrellaZoneSetting = UmbrellaZoneSetting.builder()
                .zoneName("TEST1")
                .nx(12)
                .ny(2)
                .umbrellaCount(10).build();
        umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);

        UmbrellaZoneSetting umbrellaZoneSetting1 = UmbrellaZoneSetting.builder()
                .zoneName("TEST2")
                .nx(12)
                .ny(2)
                .umbrellaCount(5).build();
        umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting1);
    }

     @Test
     @DisplayName("우산 대야존 검색")
         public void selectUmbrellaZone(){
         //given

         //when
         List<MapUmbrellaZoneDto> listMapUmbrellaZone = umbrellaZoneService.selectUmbrellaZoneAndUmbrellaCount();

         //then
         assertThat(listMapUmbrellaZone.size()).isEqualTo(2);

         for(MapUmbrellaZoneDto umbrellaZoneDto:listMapUmbrellaZone) {
             String name = umbrellaZoneDto.getName();

             if (name.equals("TEST1")) {
                 assertThat(umbrellaZoneDto.getCount()).isEqualTo(10);
             } else if (name.equals("TEST2")) {
                 assertThat(umbrellaZoneDto.getCount()).isEqualTo(5);
             }
         }

     }
}
