package com.example.umbrellaarea.umbrellaarea.Service;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaRepository;
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

    //지도에 뿌려줄 대여존 정보
    public List<UmbrellaAreaDTO> area() {
        List<UmbrellaAreaDTO> DTO=new ArrayList<UmbrellaAreaDTO>();
        List<UmbrellaArea> list=umbrellaAreaRepository.findAll();
        for (int i = 0; i <list.size() ; i++) {
            UmbrellaAreaDTO umbrellaAreaDTO=new UmbrellaAreaDTO(list.get(i));
            umbrellaAreaDTO.setCount(umbrellaRepository.countByUmbrellaAreaAndState(list.get(i),true));
            DTO.add(umbrellaAreaDTO);
        }
        return DTO;
    }
    //우산대여존 우산 갯수 조회
    public List<Umbrella> umberlla_list(Long id) {
       return umbrellaRepository.findByUmbrellaArea_Id(id);
    }






}
