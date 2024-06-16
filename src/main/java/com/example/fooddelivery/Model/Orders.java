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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersId;
    private double orderPrice;
    private String orderStatus;

    @ManyToOne
    @JoinColumn( name = "CustomerId")
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "ResturentId")
    private Resturent resturentId;

    @ManyToOne
    @JoinColumn(name = "driverId")
    private Drivers driverId;
}
