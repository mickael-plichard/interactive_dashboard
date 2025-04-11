package fr.studies.interactive_dashboard.service;

import fr.studies.interactive_dashboard.model.DataPoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DashboardServiceTest {

    @Autowired
    private DashboardService dashboardService;

    @Test
    public void testGetMockedData(){
        List<DataPoint> data = dashboardService.getMockedData();
        assertEquals(5, data.size());
        assertEquals("Ventes", data.get(0).getCategory());
        assertEquals(100.5, data.get(0).getValue());
    }

    @Test
    public void testGetDataByCategory(){
        List<DataPoint> data = dashboardService.getDataByCategory("Ventes");
        assertEquals(3, data.size());
        assertEquals("Ventes", data.get(0).getCategory());
    }
}
