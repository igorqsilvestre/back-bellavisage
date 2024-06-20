package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.model.Agendamento;
import ads4.fatesg.pbbellavisage.model.ReportBar;
import ads4.fatesg.pbbellavisage.model.ReportPizza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {
    private static final String REPORT_PIZZA_QUERY = "select t.nome, sum(a.valor) valor " +
        "from Agendamento a " +
        "inner join a.tratamento t " +
        "where a.status = :status " +
        "group by t.nome";

    private static final String REPORT_BAR_QUERY =  "select date_format(a.data, \"%m/%y\") data, sum(a.valor) valor " +
        "from agendamento a " +
        "where a.status = :status " +
        "group by date_format(a.data, \"%m/%y\") " +
        "order by date_format(a.data, \"%m/%y\") ";
    private EntityManager entityManager;

    public DashboardService(
        EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    public List<ReportPizza> getPizzaReport() {
        TypedQuery<ReportPizza> query = this.entityManager.createQuery(
            DashboardService.REPORT_PIZZA_QUERY, 
            ReportPizza.class
        );
        query.setParameter("status", Agendamento.StatusAgendamento.Concluido);
        List<ReportPizza> result = query.getResultList();
        return result;
    }

    public List<ReportBar> getBarReport() {
        Query query = this.entityManager.createNativeQuery(
                DashboardService.REPORT_BAR_QUERY,
                ReportBar.class
        );
        query.setParameter("status", Agendamento.StatusAgendamento.Concluido.toString());
        List<ReportBar> result = query.getResultList();
        return result;
    }

    
}
