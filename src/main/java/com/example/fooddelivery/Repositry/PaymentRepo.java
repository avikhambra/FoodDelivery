package com.example.fooddelivery.Repositry;

import com.example.fooddelivery.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository< Payment , Integer > {
}
