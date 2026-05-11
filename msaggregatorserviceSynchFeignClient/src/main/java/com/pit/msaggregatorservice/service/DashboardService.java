package com.pit.msaggregatorservice.service;

import com.pit.msaggregatorservice.client.CustomerClient;
import com.pit.msaggregatorservice.client.OrderClient;
import com.pit.msaggregatorservice.client.PaymentClient;
import com.pit.msaggregatorservice.dto.Customer;
import com.pit.msaggregatorservice.dto.CustomerDashboardResponse;
import com.pit.msaggregatorservice.dto.Order;
import com.pit.msaggregatorservice.dto.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final CustomerClient customerClient;
    private final OrderClient orderClient;
    private final PaymentClient paymentClient;

    public CustomerDashboardResponse getDashboard(
            Long customerId) {

        Customer customer =
                customerClient.getCustomer(customerId);

        List<Order> orders =
                orderClient.getOrders(customerId);

        List<Payment> payments =
                paymentClient.getPayments(customerId);

        return new CustomerDashboardResponse(
                customer,
                orders,
                payments
        );
    }
}
