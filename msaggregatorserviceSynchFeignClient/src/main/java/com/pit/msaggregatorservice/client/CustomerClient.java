package com.pit.msaggregatorservice.client;

import com.pit.msaggregatorservice.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "customer-service",
        url = "http://localhost:8081")
public interface CustomerClient {

    @GetMapping("/customers/{id}")
    Customer getCustomer(
            @PathVariable Long id);
}
