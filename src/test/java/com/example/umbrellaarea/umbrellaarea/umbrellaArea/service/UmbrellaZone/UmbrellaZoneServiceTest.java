package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.admin.dto.SaveUmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.admin.service.AdminUmbrellaZoneService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
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
    com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.UmbrellaZone.UmbrellaZoneService umbrellaZoneService;

    @Autowired
    UmbrellaZoneRepository umbrellaZoneRepository;

    @Autowired
    AdminUmbrellaZoneService umbrellaZoneSettingService;


    @BeforeEach
    void  init () {
        SaveUmbrellaZone umbrellaZoneSetting = SaveUmbrellaZone.builder()
                .zoneName("TEST1")
                .nx(13.0)
                .ny(3.0)
                .umbrellaCount(10).build();
        umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);

        SaveUmbrellaZone umbrellaZoneSetting1 = SaveUmbrellaZone.builder()
                .zoneName("TEST2")
                .nx(12.0)
                .ny(2.0)
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

      @Test
      @DisplayName("우산대야존 상세정보")
          public void selectDetailUmbrellaZone(){
            // given

            //when
            MapUmbrellaZoneDto mapUmbrellaZone = umbrellaZoneService.selectDetailUmbrellaZone(1L);

            //then
            assertThat(mapUmbrellaZone.getName()).isEqualTo("TEST1");
            assertThat(mapUmbrellaZone.getCount()).isEqualTo(10);
            assertThat(mapUmbrellaZone.getNx()).isEqualTo(13.0);
            assertThat(mapUmbrellaZone.getNy()).isEqualTo(3.0);
          }
}
