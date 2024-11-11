package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

}
