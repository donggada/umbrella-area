package com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.Orders;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
