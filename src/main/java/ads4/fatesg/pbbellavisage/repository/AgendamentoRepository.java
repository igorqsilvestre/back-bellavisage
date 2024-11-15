package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Agendamento;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findByPacienteIdAndStatus(Integer pacienteId,Agendamento.StatusAgendamento status);

    List<Agendamento> findByTratamentoNomeStartingWithIgnoreCaseAndStatus(String nome, Agendamento.StatusAgendamento status);

    // Método customizado que compara a data ignorando a parte da hora
    @Query("SELECT a FROM Agendamento a WHERE a.paciente.id = :pacienteId " +
            "AND a.status = :status " +
            "AND FUNCTION('DATE', a.horario.data) = FUNCTION('DATE', :data)")
    List<Agendamento> findByPacienteIdAndStatusAndHorarioData(Integer pacienteId, Agendamento.StatusAgendamento status, Date data);
}
