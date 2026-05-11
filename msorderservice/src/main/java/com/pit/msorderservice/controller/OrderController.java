package com.pit.msorderservice.controller;

import com.pit.msorderservice.dto.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrders(
            @PathVariable Long customerId) {

        return List.of(
                new Order(1L, "Laptop", 55000.0),
                new Order(2L, "Mouse", 700.0)
        );
    }
}
