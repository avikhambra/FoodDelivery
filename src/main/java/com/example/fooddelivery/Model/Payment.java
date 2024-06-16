package com.example.fooddelivery.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String paymentMode;
    private String paymentStatus;
    private Double amount;

    @OneToOne
    @JoinColumn(name = "Order Id")
    private Orders orderId;
}
