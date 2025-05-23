package fr.studies.interactive_dashboard.controller;

import fr.studies.interactive_dashboard.model.DataPoint;
import fr.studies.interactive_dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardController {
    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/api/dashboard")
    public List<DataPoint> getDashboardData(
            @RequestParam(value = "category", required = false) String category
    ){
        if (category != null && !category.isEmpty()) {
            return dashboardService.getDataByCategory(category);
        }
        return dashboardService.getMockedData();
    }


}
