package com.pit.msaggregatorservice.controller;

import com.pit.msaggregatorservice.dto.CustomerDashboardResponse;
import com.pit.msaggregatorservice.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/{customerId}")
    public CustomerDashboardResponse getDashboard(
            @PathVariable Long customerId)
            throws Exception {

        return dashboardService
                .getDashboard(customerId);
    }
}