package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.admin.dto.UmbrellaZoneSetting;
import com.example.umbrellaarea.umbrellaarea.admin.service.UmbrellaZoneSettingService;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Umbrella.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone.UmbrellaZoneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UmbrellaServiceTest {

    @Autowired
    UmbrellaRepository umbrellaRepository;

    @Autowired
    UmbrellaZoneRepository umbrellaZoneRepository;

    @Autowired
    UmbrellaService umbrellaService;

    @Autowired
    UmbrellaZoneSettingService umbrellaZoneSettingService;

    @BeforeEach
    void  savaUmbrella () {
        UmbrellaZoneSetting umbrellaZoneSetting = UmbrellaZoneSetting.builder()
                .zoneName("TEST1")
                .nx(12)
                .ny(2)
                .umbrellaCount(5).build();
        umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting);

        UmbrellaZoneSetting umbrellaZoneSetting1 = UmbrellaZoneSetting.builder()
                .zoneName("TEST2")
                .nx(12)
                .ny(2)
                .umbrellaCount(5).build();
        umbrellaZoneSettingService.saveUmbrellaZone(umbrellaZoneSetting1);

    }

    @Test
    @DisplayName("우산 대여")
    public void borrowUmbrella () throws Exception {
        //given
        Long umbrellaId = 2L;
        //when
        Umbrella umbrella = umbrellaService.borrowUmbrella(umbrellaId);
        Umbrella findUmbrella = umbrellaRepository.findById(umbrellaId)
                .orElseThrow(() -> new IllegalArgumentException("우산 데이터 없음!!"));
        //then
        Assertions.assertThat(umbrella).isNotNull();
        Assertions.assertThat(findUmbrella.isState()).isFalse();
        Assertions.assertThat(umbrella.getId()).isEqualTo(findUmbrella.getId());
    }

    @Test
    @DisplayName("우산 반납")
    public void returnUmbrella() throws Exception {
    //given
        Long umbrellaId = 2L;
        UmbrellaZone returnZone = UmbrellaZone.createUmbrellaZone("returnZone", 12, 35);
        Umbrella borrowUmbrella = umbrellaService.borrowUmbrella(umbrellaId);
        //when
        Umbrella returnUmbrella = umbrellaService.returnUmbrella(returnZone, umbrellaId);
        //then
        Assertions.assertThat(returnUmbrella).isNotNull();
        Assertions.assertThat(returnUmbrella.isState()).isTrue();
    }
}
