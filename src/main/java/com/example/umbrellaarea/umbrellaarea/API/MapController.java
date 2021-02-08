package com.example.umbrellaarea.umbrellaarea.API;

import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaRepository;
import com.example.umbrellaarea.umbrellaarea.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MapController {
    @Autowired
    MapService mapService;
    @Autowired
    UmbrellaRepository umbrellaRepository;
    @GetMapping("/umbrellafirst")
    public List<Umbrella> sitting(){
        return mapService.umbrella_add(mapService.umbrella_first());

    }
    @GetMapping("/umbrellacount")
    public Long umbrella_count(){
        return mapService.umbrella_count();
    }
    @GetMapping("/list/{id}")
    public List<Umbrella> list(@PathVariable(name = "id") Long id){
        return  mapService.umberlla_list(id);
    }

    @GetMapping("/area")
    public List<UmbrellaAreaDTO> area(){
        return mapService.area();
    }

}
