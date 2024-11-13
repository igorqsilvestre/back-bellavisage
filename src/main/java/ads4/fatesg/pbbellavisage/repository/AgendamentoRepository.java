package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Agendamento;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findByPacienteIdAndStatus(Integer pacienteId,Agendamento.StatusAgendamento status);

    List<Agendamento> findByTratamentoNomeStartingWithIgnoreCaseAndStatus(String nome, Agendamento.StatusAgendamento status);
}
