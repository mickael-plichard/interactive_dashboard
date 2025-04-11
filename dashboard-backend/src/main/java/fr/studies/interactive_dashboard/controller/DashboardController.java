package fr.studies.interactive_dashboard.controller;

import fr.studies.interactive_dashboard.model.DataPoint;
import fr.studies.interactive_dashboard.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardController {
    private final DashboardService dashboardService = new DashboardService();

    @GetMapping("/api/dashboard")
    public List<DataPoint> getDashboardData(){
        return dashboardService.getMockedData();
    }
}
