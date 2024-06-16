package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.OrdersDto;

import java.util.List;

public interface OrderService {

    OrdersDto createOrder(OrdersDto ordersDto, Integer userId,Integer resturentId, Integer driverId);

    // All Orders
    List<OrdersDto> getAllOrders();

    // Single Orders
    OrdersDto getSingleOrders(Integer ordersId);

    //Update Orders
    OrdersDto updateOrders(OrdersDto ordersDto, Integer ordersId);

    // Delete Orders
    String deleteOrders(Integer ordersId);
}
