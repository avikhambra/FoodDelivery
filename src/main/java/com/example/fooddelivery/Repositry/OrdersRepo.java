package com.example.fooddelivery.Repositry;

import com.example.fooddelivery.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders , Integer> {
}
