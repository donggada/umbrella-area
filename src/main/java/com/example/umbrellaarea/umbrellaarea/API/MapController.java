package com.example.umbrellaarea.umbrellaarea.API;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RestController
public class MapController {
    @Autowired
    MapService mapService;
    @Autowired
    UmbrellaRepository umbrellaRepository;
    @Autowired
    UmbrellaAreaRepository umbrellaAreaRepository;
    // 우산대여존 초기 설정 (수정해야함)
    @GetMapping("/umbrellafirst")
    public List<Umbrella> sitting(){
        return mapService.umbrella_add(mapService.umbrella_first());

    }
    //테스트
    @GetMapping("/umbrellacount")
    public Long umbrella_count(){
        return mapService.umbrella_count();
    }

    //대여존 우산 갯수 조회
    @GetMapping("/list/{id}")
    public List<Umbrella> list(@PathVariable(name = "id") Long id){
        return  mapService.umberlla_list(id);
    }
    //우산 지도에 뿌려줄 대여존 정보
    @GetMapping("/area")
    public List<UmbrellaAreaDTO> area(){
        return mapService.area();
    }
    //update test
    @GetMapping("/timetest/{id}")
    public Integer timetest(@PathVariable(name = "id") Long id){
        Timestamp date=new Timestamp(System.currentTimeMillis());
        return umbrellaRepository.timetest(id,false);
    }
    //우산 차례대로 주무되도록!!
    @GetMapping("ordertest")
    public UmbrellaDTO ordertest(){
        Queue<Umbrella> queue=new LinkedList<Umbrella>();
        queue.addAll(umbrellaRepository.findByStateAndOrderByDate(true));
        umbrellaRepository.order(queue.peek().getId(),!queue.peek().isState());
        UmbrellaDTO umbrella=new UmbrellaDTO(queue.poll(),false);

        return umbrella;

    }



}
