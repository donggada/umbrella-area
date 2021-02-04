package com.example.umbrellaarea.umbrellaarea.Service;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MapService {
    @Autowired
    UmbrellaRepository umbrellaRepository;
    @Autowired
    UmbrellaAreaRepository umbrellaAreaRepository;
    public UmbrellaArea umbrella_first() {
        UmbrellaAreaDTO umbrellaAreaDTO=new UmbrellaAreaDTO();
        umbrellaAreaDTO.setName("동탄 5동");
        umbrellaAreaDTO.setNx(37.20);
        umbrellaAreaDTO.setNy(127.1);
        UmbrellaArea umbrellaArea=new UmbrellaArea(umbrellaAreaDTO);

        return umbrellaAreaRepository.save(umbrellaArea);

    }

    public Long umbrella_count() {

        return umbrellaRepository.countByUmbrellaArea(umbrellaAreaRepository.getOne(49L));
    }

    public List<Umbrella> umbrella_add(UmbrellaArea umbrellaArea) {
        ArrayList<Umbrella> arrayList=new ArrayList<Umbrella>();
        for (int i = 0; i <10 ; i++) {
            UmbrellaDTO umbrellaDTO=new UmbrellaDTO();
            umbrellaDTO.setPrice(1000L);
            umbrellaDTO.setUmbrellaArea(umbrellaArea);
            Umbrella umbrella=new Umbrella(umbrellaDTO);
            arrayList.add(umbrella);
        }
        umbrellaRepository.saveAll(arrayList);


        return umbrellaRepository.findAll();
    }

    public List<UmbrellaAreaDTO> area() {
        List<UmbrellaAreaDTO> DTO=new ArrayList<UmbrellaAreaDTO>();
        List<UmbrellaArea> list=umbrellaAreaRepository.findAll();
        for (int i = 0; i <list.size() ; i++) {
            UmbrellaAreaDTO umbrellaAreaDTO=new UmbrellaAreaDTO(list.get(i));
            umbrellaAreaDTO.setCount(umbrellaRepository.countByUmbrellaArea(list.get(i)));
            DTO.add(umbrellaAreaDTO);
        }
        return DTO;
    }
}
