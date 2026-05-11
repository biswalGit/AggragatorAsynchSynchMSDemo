package com.pit.msaggregatorservice.service;

import com.pit.msaggregatorservice.client.CustomerClient;
import com.pit.msaggregatorservice.client.OrderClient;
import com.pit.msaggregatorservice.client.PaymentClient;
import com.pit.msaggregatorservice.dto.Customer;
import com.pit.msaggregatorservice.dto.Order;
import com.pit.msaggregatorservice.dto.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncAggregatorService {

    private final CustomerClient customerClient;
    private final OrderClient orderClient;
    private final PaymentClient paymentClient;

    @Async
    public CompletableFuture<Customer> getCustomer(
            Long customerId) {
        System.out.println(
                "Customer Thread : "
                        + Thread.currentThread().getName());
        Customer customer =
                customerClient.getCustomer(customerId);

        return CompletableFuture.completedFuture(
                customer);
    }

    @Async
    public CompletableFuture<List<Order>> getOrders(
            Long customerId) {
        System.out.println(
                "Order Thread : "
                        + Thread.currentThread().getName());
        List<Order> orders =
                orderClient.getOrders(customerId);

        return CompletableFuture.completedFuture(
                orders);
    }

    @Async
    public CompletableFuture<List<Payment>> getPayments(
            Long customerId) {
        System.out.println(
                "Payment Thread : "
                        + Thread.currentThread().getName());
        List<Payment> payments =
                paymentClient.getPayments(customerId);

        return CompletableFuture.completedFuture(
                payments);
    }
}
