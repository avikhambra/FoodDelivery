package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto createPayment(PaymentDto paymentDto, Integer orderId);

    // All Payment
    List<PaymentDto> getAllPayments();

    // Single Payment
    PaymentDto getSinglePayment(Integer paymentId);

    //Update Payment
    PaymentDto updatePayment(PaymentDto paymentDto, Integer paymentId);

    // Delete Payment
    String deletePayment(Integer paymentId);
}
