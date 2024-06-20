package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.model.ReportBar;
import ads4.fatesg.pbbellavisage.model.ReportPizza;
import ads4.fatesg.pbbellavisage.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/dashboard")
public class DashboardResource {

    @Autowired
    private DashboardService dashboardService;
    @GetMapping(
            value = "/report-pizza",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<ReportPizza> getPizzaReport() {
        return this.dashboardService.getPizzaReport();
    }

    @GetMapping(
            value = "/report-bar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<ReportBar> getBarReport() {
        return this.dashboardService.getBarReport();
    }
}
