package com.pit.msaggregatorservice.client;

import com.pit.msaggregatorservice.dto.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "order-service",
        url = "http://localhost:8082")
public interface OrderClient {

    @GetMapping("/orders/customer/{id}")
    List<Order> getOrders(
            @PathVariable Long id);
}
