package com.example.fooddelivery.Controller;

import com.example.fooddelivery.Dto.PaymentDto;
import com.example.fooddelivery.Service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    @PostMapping("/order/{orderId}")
    public ResponseEntity<PaymentDto> createPayment(
            @RequestBody PaymentDto paymentDto,
            @PathVariable Integer orderId){
        PaymentDto paymentDto1 = paymentService.createPayment(paymentDto, orderId);

        return new ResponseEntity<>(paymentDto1, HttpStatus.CREATED);
    }

    // All Payment
    @GetMapping("/allPayments")
    ResponseEntity<List<PaymentDto>> AllPayments(){
        List<PaymentDto> paymentDtos = paymentService.getAllPayments();
        return new ResponseEntity<>(paymentDtos, HttpStatus.OK);
    };

    // Single Payment
    @GetMapping("/{paymentId}")
    ResponseEntity<PaymentDto> SinglePayment(@PathVariable Integer paymentId){
        PaymentDto paymentDto = paymentService.getSinglePayment(paymentId);
        return new ResponseEntity<>(paymentDto, HttpStatus.OK);
    };

    //Update Payment
    @PostMapping("/{paymentId}")
    ResponseEntity<PaymentDto> updatePayment(
            @RequestBody PaymentDto paymentDto,
            @PathVariable Integer paymentId){
        PaymentDto paymentDto1 = paymentService.updatePayment(paymentDto,paymentId);
        return new ResponseEntity<>(paymentDto1, HttpStatus.OK);
    };

    // Delete Payment
    @DeleteMapping("/{paymentId}")
    ResponseEntity<String> deletePayment(@PathVariable Integer paymentId){
        paymentService.deletePayment(paymentId);
        return new ResponseEntity<>("Payment Declined", HttpStatus.OK);
    };
}
