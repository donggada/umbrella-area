package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.admin.dto.UmbrellaZoneSetting;
import com.example.umbrellaarea.umbrellaarea.admin.service.UmbrellaZoneSettingService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
         List<MapUmbrellaZoneDto> mapUmbrellaZoneDto = umbrellaZoneService.selectUmbrllaZoneAndUmbrellaCount();
         //then
         Assertions.assertThat(mapUmbrellaZoneDto.size()).isEqualTo(2);
         }
}
