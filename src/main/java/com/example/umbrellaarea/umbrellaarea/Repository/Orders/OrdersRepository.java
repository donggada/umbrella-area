package com.example.umbrellaarea.umbrellaarea.Repository.Orders;

import com.example.umbrellaarea.umbrellaarea.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
