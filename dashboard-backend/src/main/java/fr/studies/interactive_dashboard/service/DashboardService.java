package fr.studies.interactive_dashboard.service;

import fr.studies.interactive_dashboard.model.DataPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DashboardService {
    public List<DataPoint> getMockedData() {
        return Stream.of(
                new DataPoint("2025-04-01", 100.5, "Ventes"),
                new DataPoint("2025-04-02", 150.0, "Ventes"),
                new DataPoint("2025-04-03", 80.0, "Utilisateurs"),
                new DataPoint("2025-04-04", 200.0, "Ventes"),
                new DataPoint("2025-04-05", 120.0, "Utilisateurs")
        ).collect(Collectors.toList());
    }
}
