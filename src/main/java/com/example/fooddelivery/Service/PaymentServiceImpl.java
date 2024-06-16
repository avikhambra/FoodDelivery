package com.example.fooddelivery.Service;


import com.example.fooddelivery.Dto.OrdersDto;
import com.example.fooddelivery.Dto.PaymentDto;
import com.example.fooddelivery.Model.Orders;
import com.example.fooddelivery.Model.Payment;
import com.example.fooddelivery.Repositry.OrdersRepo;
import com.example.fooddelivery.Repositry.PaymentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private ModelMapper modelMapper;
    private PaymentRepo paymentRepo;
    private OrdersRepo ordersRepo;
//    private OrdersDto ordersDto;

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto, Integer orderId) {
        Orders orders = ordersRepo.findById(orderId).orElseThrow(()-> new RuntimeException("Order not found"));

        Payment payment = DtoToPayment(paymentDto);
        payment.setOrderId(orders);
        payment.setAmount(orders.getOrderPrice());
        Payment payment1 = paymentRepo.save(payment);

        return paymentToDto(payment1);

    }

    @Override
    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepo.findAll();
        return payments.stream().map( pay-> paymentToDto(pay)).collect(Collectors.toList());
    }

    @Override
    public PaymentDto getSinglePayment(Integer paymentId) {
        Payment payment = paymentRepo.findById(paymentId).get();
        return paymentToDto(payment);
    }

    @Override
    public PaymentDto updatePayment(PaymentDto paymentDto, Integer paymentId) {
        Payment payment = paymentRepo.findById(paymentId).get();

        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentMode(paymentDto.getPaymentMode());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());

        Payment payment1 = paymentRepo.save(payment);
        return paymentToDto(payment1);
    }

    @Override
    public String deletePayment(Integer paymentId) {
        Payment payment = paymentRepo.findById(paymentId).get();
        paymentRepo.delete(payment);
        return "";
    }


    // ModelMapper
    Payment DtoToPayment(PaymentDto paymentDto){
        return modelMapper.map(paymentDto, Payment.class);
    }
    PaymentDto paymentToDto(Payment payment){
        return modelMapper.map(payment, PaymentDto.class);
    }

}
