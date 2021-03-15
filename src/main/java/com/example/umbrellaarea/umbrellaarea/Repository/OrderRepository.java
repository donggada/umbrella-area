package com.example.umbrellaarea.umbrellaarea.Repository;

import com.example.umbrellaarea.umbrellaarea.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
