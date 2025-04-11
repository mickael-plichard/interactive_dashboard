package fr.studies.interactive_dashboard.service;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import fr.studies.interactive_dashboard.model.DataPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DashboardService {
    private final LoadingCache<String, List<DataPoint>> cache;

    public DashboardService() {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(100)
                .build(key -> loadMockedData().join());
    }

    private CompletableFuture<List<DataPoint>> loadMockedData() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Delay simulation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return Stream.of(
                new DataPoint("2025-04-01", 100.5, "Ventes"),
                new DataPoint("2025-04-02", 150.0, "Ventes"),
                new DataPoint("2025-04-03", 80.0, "Utilisateurs"),
                new DataPoint("2025-04-04", 200.0, "Ventes"),
                new DataPoint("2025-04-05", 120.0, "Utilisateurs")
        ).collect(Collectors.toList());
    });
        }

    public List<DataPoint> getMockedData(){
        return cache.get("mockedData");
    }

    public List<DataPoint> getDataByCategory(String category) {
        return cache.get("mockedData")
                .stream()
                .filter(point -> point.getCategory()
                        .equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
