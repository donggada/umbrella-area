package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Service.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.DTO.UmbrellaZone.SaveUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity.UmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Repository.UmbrellaZone.UmbrellaZoneRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UmbrellaZoneServiceSaveTest {
	@Autowired
	EntityManager entityManager;
	@Autowired
	UmbrellaZoneRepository umbrellaZoneRepository;

	 @Test
	     public void saveUmbrellaZone(){
	     //given
		 SaveUmbrellaZoneDto saveUmbrellaZoneDto = new SaveUmbrellaZoneDto();
		 saveUmbrellaZoneDto.setName("동탄점");
		 saveUmbrellaZoneDto.setNx(27.0);
		 saveUmbrellaZoneDto.setNy(127.3);
		 saveUmbrellaZoneDto.setAdders("경기도 화성시 동탄영천로 108-21");

		 UmbrellaZone umbrellaZone = new UmbrellaZone(saveUmbrellaZoneDto);

		 //when
		 UmbrellaZone saveUmbrellaZone = umbrellaZoneRepository.save(umbrellaZone);

		 //then
		 assertThat(saveUmbrellaZone.getName().equals("동탄점"));
		 assertThat(saveUmbrellaZone.getNx() == 27.0);
		 assertThat(saveUmbrellaZone.getNy() == 127.3);
		 assertThat(saveUmbrellaZone.getAdders().equals("경기도 화성시 동탄영천로 108-21"));

	     }

}
