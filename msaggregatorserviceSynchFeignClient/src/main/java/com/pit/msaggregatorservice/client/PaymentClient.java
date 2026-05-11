package com.pit.msaggregatorservice.client;

import com.pit.msaggregatorservice.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "payment-service",
        url = "http://localhost:8083")
public interface PaymentClient {

    @GetMapping("/payments/customer/{id}")
    List<Payment> getPayments(
            @PathVariable Long id);
}