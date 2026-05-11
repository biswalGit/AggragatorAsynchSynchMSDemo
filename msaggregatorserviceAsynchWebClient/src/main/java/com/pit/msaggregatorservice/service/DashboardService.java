package com.pit.msaggregatorservice.service;

import com.pit.msaggregatorservice.dto.Customer;
import com.pit.msaggregatorservice.dto.CustomerDashboardResponse;
import com.pit.msaggregatorservice.dto.Order;
import com.pit.msaggregatorservice.dto.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final WebClient webClient;

    public CustomerDashboardResponse getDashboard(
            Long customerId) {

        // CUSTOMER API CALL
       /* Customer customer = webClient
                .get()
                .uri("http://localhost:8081/customers/" + customerId)
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
*/
        Mono<Customer> customerMono = webClient
                .get()
                .uri("http://localhost:8081/customers/" + customerId)
                .retrieve()
                .bodyToMono(Customer.class);

        // ORDER API CALL
       /* List<Order> orders = webClient
                .get()
                .uri("http://localhost:8082/orders/customer/" + customerId)
                .retrieve()
                .bodyToFlux(Order.class)
                .collectList()
                .block();*/
        Mono<List<Order>> ordersMono = webClient
                .get()
                .uri("http://localhost:8082/orders/customer/" + customerId)
                .retrieve()
                .bodyToFlux(Order.class)
                .collectList();

        // PAYMENT API CALL
       /* List<Payment> payments = webClient
                .get()
                .uri("http://localhost:8083/payments/customer/" + customerId)
                .retrieve()
                .bodyToFlux(Payment.class)
                .collectList()
                .block();*/
        Mono<List<Payment>> paymentsMono = webClient
                .get()
                .uri("http://localhost:8083/payments/customer/" + customerId)
                .retrieve()
                .bodyToFlux(Payment.class)
                .collectList();

        return Mono.zip(
                customerMono,
                ordersMono,
                paymentsMono
        ).map(tuple -> {

            Customer customer = tuple.getT1();
            List<Order> orders = tuple.getT2();
            List<Payment> payments = tuple.getT3();

            return new CustomerDashboardResponse(
                    customer,
                    orders,
                    payments
            );
        }).block();
    }
}
