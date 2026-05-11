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
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final AsyncAggregatorService asyncService;

    public CustomerDashboardResponse getDashboard(
            Long customerId) throws Exception {

        CompletableFuture<Customer> customerFuture =
                asyncService.getCustomer(customerId);

        CompletableFuture<List<Order>> orderFuture =
                asyncService.getOrders(customerId);

        CompletableFuture<List<Payment>> paymentFuture =
                asyncService.getPayments(customerId);

        // WAIT FOR ALL
        CompletableFuture.allOf(
                customerFuture,
                orderFuture,
                paymentFuture
        ).join();

        Customer customer = customerFuture.get();

        List<Order> orders = orderFuture.get();

        List<Payment> payments = paymentFuture.get();

        return new CustomerDashboardResponse(
                customer,
                orders,
                payments
        );
    }
}