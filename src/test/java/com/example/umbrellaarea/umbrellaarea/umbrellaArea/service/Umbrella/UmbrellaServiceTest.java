package com.example.umbrellaarea.umbrellaarea.umbrellaArea.service.Umbrella;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Umbrella;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UmbrellaServiceTest {
    @Autowired
    UmbrellaService umbrellaService;

    @Test
    public void borrowUmbrella () throws Exception {
        //given
        Long umbrellaId = 1L;
        //when
        Umbrella umbrella = umbrellaService.borrowUmbrella(umbrellaId);
        //then
        Assertions.assertThat(umbrella).isNotNull();
        Assertions.assertThat(umbrella.getId()).isEqualTo(umbrellaId);
    }
}
