package com.example.umbrellaarea.umbrellaarea.Service;

import com.example.umbrellaarea.umbrellaarea.Controller.QRCode;
import com.example.umbrellaarea.umbrellaarea.DTO.OrderDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaAreaDTO;
import com.example.umbrellaarea.umbrellaarea.DTO.UmbrellaDTO;
import com.example.umbrellaarea.umbrellaarea.Entity.Orders;
import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Repository.MemberRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.OrderRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaAreaRepository;
import com.example.umbrellaarea.umbrellaarea.Repository.UmbrellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.Queue;

@Service
@Transactional
public class OrderService {
    @Autowired
    UmbrellaRepository umbrellaRepository;
    @Autowired
    UmbrellaAreaRepository umbrellaAreaRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;
    //주문 작업 수행 (회원아이디값 넣기)
    public Orders order(Long id,String member_id) {
        Queue<Umbrella> queue=new LinkedList<Umbrella>();
        queue.addAll(umbrellaRepository.findByUmbrellaArea_IdAndStateOrderByDate(id,true));
        Long umbrellaid=queue.peek().getId();
        //아아디 값 가져오기(QR코드 name = 회원ID + 우산 ID 조합)
        String qrname=member_id+umbrellaid;
        QRCode qrCode=new QRCode(id+"",qrname);

        umbrellaRepository.order(umbrellaid,!queue.peek().isState());
        OrderDTO orderDTO=new OrderDTO(new Umbrella(new UmbrellaDTO(queue.poll(),false)),memberRepository.findById(member_id));
        orderDTO.setQR("/QRCode/"+qrname);
        return  orderRepository.save(new Orders(orderDTO));
    }
    public OrderDTO myorder(Long id) {
        return new OrderDTO(orderRepository.getOne(id));
    }

    //우산대여존 상세페이지 조회
    public UmbrellaAreaDTO orderinfo(Long id){
        UmbrellaAreaDTO umbrellaAreaDTO=new UmbrellaAreaDTO(umbrellaAreaRepository.findById(id).get());
        umbrellaAreaDTO.setCount(umbrellaRepository.countByUmbrellaAreaAndState(umbrellaAreaRepository.getOne(id),true));
        return umbrellaAreaDTO;
    }

}
