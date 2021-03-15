package com.example.umbrellaarea.umbrellaarea.Service;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    UmbrellaRepository umbrellaRepository;
    @Autowired
    UmbrellaAreaRepository umbrellaAreaRepository;

     // 우산대여존 초기 설정 (수정해야함)
    public UmbrellaArea umbrella_first(UmbrellaAreaDTO umbrellaAreaDTO) {
        System.out.println(umbrellaAreaDTO.getNx());
        System.out.println(umbrellaAreaDTO.getName());
        System.out.println(umbrellaAreaDTO.getNy());
        UmbrellaArea umbrellaArea=new UmbrellaArea(umbrellaAreaDTO);
        return umbrellaAreaRepository.save(umbrellaArea);
    }

    public List<Umbrella> umbrella_add(UmbrellaArea umbrellaArea, Long count) {
        ArrayList<Umbrella> arrayList=new ArrayList<Umbrella>();
        for (int i = 0; i <count ; i++) {
            UmbrellaDTO umbrellaDTO=new UmbrellaDTO();
            umbrellaDTO.setUmbrellaArea(umbrellaArea);
            Umbrella umbrella=new Umbrella(umbrellaDTO);
            arrayList.add(umbrella);
        }
        umbrellaRepository.saveAll(arrayList);


        return umbrellaRepository.findAll();
    }

    // 우산대여존 초기 설정 (수정해야함)
    public List<Umbrella> sitting(UmbrellaAreaDTO umbrellaAreaDTO){
        return umbrella_add(umbrella_first(umbrellaAreaDTO),umbrellaAreaDTO.getCount());
    }
}
