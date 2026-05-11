package com.pit.mscustomerservice.controller;

import com.pit.mscustomerservice.dto.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {

        return new Customer(
                id,
                "John Doe",
                "john@gmail.com");
    }
}
