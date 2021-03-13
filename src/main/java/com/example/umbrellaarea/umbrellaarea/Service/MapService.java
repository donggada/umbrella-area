package com.example.umbrellaarea.umbrellaarea.Service;

import com.example.umbrellaarea.umbrellaarea.Controller.QRCode;
import com.example.umbrellaarea.umbrellaarea.DTO.MyOrderDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //우산대여존 상세페이지 조회
    public UmbrellaAreaDTO orderinfo(Long id){
        UmbrellaAreaDTO umbrellaAreaDTO=new UmbrellaAreaDTO(umbrellaAreaRepository.findById(id).get());
        umbrellaAreaDTO.setCount(umbrellaRepository.countByUmbrellaArea(umbrellaAreaRepository.getOne(id)));
        return umbrellaAreaDTO;
    }

    public MyOrderDTO order(Long id) {
        Queue<Umbrella> queue=new LinkedList<Umbrella>();
        queue.addAll(umbrellaRepository.findByUmbrellaArea_IdAndStateOrderByDate(id,true));
        Long umbrellaid=queue.peek().getId();
        String qrname="memberid_"+umbrellaid;
        QRCode qrCode=new QRCode(id+"",qrname);
        umbrellaRepository.order(umbrellaid,!queue.peek().isState());
        MyOrderDTO myOrderDTO=new MyOrderDTO(queue.poll(),false);
        myOrderDTO.setQR("/QRCode/"+qrname);
        return myOrderDTO;
    }

    public List<Umbrella> myorder(Long id) {
        return umbrellaRepository.findByUmbrellaArea_IdAndStateOrderByDate(id,true);
    }
}
