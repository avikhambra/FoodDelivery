package com.example.fooddelivery.Dto;

import com.example.fooddelivery.Model.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDto {

    private Integer paymentId;
    private String paymentMode;
    private String paymentStatus;
    private Double amount;

    private Orders orderId;
}
