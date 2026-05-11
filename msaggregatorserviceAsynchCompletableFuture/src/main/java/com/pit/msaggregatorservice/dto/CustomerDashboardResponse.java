package com.pit.msaggregatorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDashboardResponse {

    private Customer customer;
    private List<Order> orders;
    private List<Payment> payments;
}
