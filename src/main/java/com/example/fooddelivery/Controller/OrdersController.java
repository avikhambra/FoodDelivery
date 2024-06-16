package com.example.fooddelivery.Controller;


import com.example.fooddelivery.Dto.OrdersDto;
import com.example.fooddelivery.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.OpenURIEvent;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrdersController {

    private OrderService orderService;

    @PostMapping("/resturent/{resturentId}/user/{userId}/driver/{driverId}")
    public ResponseEntity<OrdersDto> createOrder(
            @RequestBody OrdersDto ordersDto,
            @PathVariable Integer userId,
            @PathVariable Integer resturentId,
            @PathVariable Integer driverId) {

        OrdersDto ordersDto1 = orderService.createOrder(ordersDto,userId, resturentId,driverId );
        return new ResponseEntity<>( ordersDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrdersDto> singleOrder(@PathVariable Integer orderId){
        OrdersDto ordersDto = orderService.getSingleOrders(orderId);
        return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }

    @GetMapping("/allOrders")
    ResponseEntity<List<OrdersDto>> AllOrders(){
        List<OrdersDto> ordersDtos = orderService.getAllOrders();
        return new ResponseEntity<>(ordersDtos, HttpStatus.OK);
    }

    @PostMapping("/{ordersId}")
    public ResponseEntity<OrdersDto> updateOrders(
            @RequestBody OrdersDto ordersDto,
            @PathVariable Integer ordersId){
       OrdersDto ordersDto1 =  orderService.updateOrders(ordersDto,ordersId);
    return new ResponseEntity<>(ordersDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{ordersId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer ordersId){
        orderService.deleteOrders(ordersId);
        return new ResponseEntity<>("Order Cancel", HttpStatus.OK);
    }

}
