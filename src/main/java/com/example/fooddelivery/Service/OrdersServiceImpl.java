package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.OrdersDto;
import com.example.fooddelivery.Model.Drivers;
import com.example.fooddelivery.Model.Orders;
import com.example.fooddelivery.Model.Resturent;
import com.example.fooddelivery.Model.Users;
import com.example.fooddelivery.Repositry.DriversRepo;
import com.example.fooddelivery.Repositry.OrdersRepo;
import com.example.fooddelivery.Repositry.ResturentRepo;
import com.example.fooddelivery.Repositry.UsersRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private OrdersRepo ordersRepo;
    private UsersRepo usersRepo;
    private ResturentRepo resturentRepo;
    private DriversRepo driversRepo;
    private ModelMapper modelMapper;


    @Override
    public OrdersDto createOrder(OrdersDto ordersDto, Integer userId, Integer resturentId, Integer driverId) {

        Users users = usersRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        Resturent resturent = resturentRepo.findById(resturentId).orElseThrow(()-> new RuntimeException("resturent not found"));
        Drivers drivers = driversRepo.findById(driverId).orElseThrow(()-> new RuntimeException("Driver not available"));

        Orders orders = DtoToOrder(ordersDto);
        orders.setUserId(users);
        orders.setResturentId(resturent);
        orders.setDriverId(drivers);

        Orders orders1 = ordersRepo.save(orders);
        return OrderToDto(orders1);

    }

    @Override
    public List<OrdersDto> getAllOrders() {
        List<Orders> orders = ordersRepo.findAll();
        return orders.stream().map( order-> OrderToDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrdersDto getSingleOrders(Integer ordersId) {
        Orders orders = ordersRepo.findById(ordersId).get();
        return OrderToDto(orders);
    }

    @Override
    public OrdersDto updateOrders(OrdersDto ordersDto, Integer ordersId) {
        Orders orders = ordersRepo.findById(ordersId).get();
        orders.setOrderPrice(ordersDto.getOrderPrice());
        orders.setOrderStatus(ordersDto.getOrderStatus());

        Orders orders1 = ordersRepo.save(orders);
        return OrderToDto(orders1);
    }

    @Override
    public String deleteOrders(Integer ordersId) {
        Orders orders = ordersRepo.findById(ordersId).get();
        ordersRepo.delete(orders);
        return "";
    }





    // Model Mapper
    Orders DtoToOrder(OrdersDto ordersDto){
        return modelMapper.map(ordersDto, Orders.class);
    }
    OrdersDto OrderToDto(Orders orders){
        return modelMapper.map(orders, OrdersDto.class);
    }
}
