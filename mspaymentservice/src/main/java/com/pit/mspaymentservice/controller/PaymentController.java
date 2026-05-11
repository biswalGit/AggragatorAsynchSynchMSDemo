package com.pit.mspaymentservice.controller;

import com.pit.mspaymentservice.dto.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping("/customer/{customerId}")
    public List<Payment> getPayments(
            @PathVariable Long customerId) {

        return List.of(
                new Payment(101L, "SUCCESS", 55000.0),
                new Payment(102L, "PENDING", 700.0)
        );
    }
}
