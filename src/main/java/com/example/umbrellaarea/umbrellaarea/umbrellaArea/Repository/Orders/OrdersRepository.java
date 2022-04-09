package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Repository.Orders;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
