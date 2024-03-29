package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.admin.dto.SaveUmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.admin.service.AdminUmbrellaZoneService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UmbrellaServiceTest {

    @Autowired
    UmbrellaRepository umbrellaRepository;

    @Autowired
    UmbrellaZoneRepository umbrellaZoneRepository;

    @Autowired
    UmbrellaService umbrellaService;

    @Autowired
    AdminUmbrellaZoneService umbrellaZoneSettingService;

    @BeforeEach
    void  savaUmbrella () {
        SaveUmbrellaZone umbrellaZoneSetting = SaveUmbrellaZone.builder()
                .zoneName("TEST1")
                .nx(12)
                .ny(2)
                .umbrellaCount(5).build();
        umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);

        SaveUmbrellaZone umbrellaZoneSetting1 = SaveUmbrellaZone.builder()
                .zoneName("TEST2")
                .nx(12)
                .ny(2)
                .umbrellaCount(5).build();
        umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting1);

    }

    @Test
    @DisplayName("우산 대여")
    public void borrowUmbrella () {
        //given
        Long umbrellaId = 2L;
        //when
        Umbrella umbrella = umbrellaService.borrowUmbrella(umbrellaId);
        Umbrella findUmbrella = umbrellaRepository.findById(umbrellaId)
                .orElseThrow(() -> new IllegalArgumentException("우산 데이터 없음!!"));
        //then
        assertThat(umbrella).isNotNull();
        assertThat(findUmbrella.isState()).isFalse();
        assertThat(umbrella.getId()).isEqualTo(findUmbrella.getId());
    }

    @Test
    @DisplayName("우산 반납")
    public void returnUmbrella() {
    //given
        Long umbrellaId = 2L;
        Umbrella borrowUmbrella = umbrellaService.borrowUmbrella(umbrellaId);
        //when
        Umbrella returnUmbrella = umbrellaService.returnUmbrella(7L, umbrellaId);
        //then
        assertThat(returnUmbrella).isNotNull();
        assertThat(returnUmbrella.isState()).isTrue();

    }

     @Test
     @DisplayName("우산 조회")
         public void selectUmbrella (){
             //given
               Long umbrellaZoneId = 1L;
             //when
         List<Umbrella> umbrellaList = umbrellaRepository.findByUmbrellaZoneIdAndState(umbrellaZoneId, false);
         System.out.println(umbrellaList);
         //then
            assertThat(umbrellaList.size()).isEqualTo(5);
         }
}
