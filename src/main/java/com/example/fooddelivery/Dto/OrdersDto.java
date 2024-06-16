package com.example.fooddelivery.Dto;

import com.example.fooddelivery.Model.Drivers;
import com.example.fooddelivery.Model.Resturent;
import com.example.fooddelivery.Model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersDto {

    private Integer ordersId;
    private double orderPrice;
    private String orderStatus;

    private Resturent resturentId;
    private Users userId;
    private Drivers driverId;


}
