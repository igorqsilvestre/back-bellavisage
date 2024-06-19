package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.dto.AgendamentoCreateDto;
import ads4.fatesg.pbbellavisage.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    @Query("SELECT CASE " +
            "WHEN :id IS NULL AND COUNT(a) > 0 THEN true " +
            "WHEN :id IS NOT NULL AND COUNT(a) > 0 THEN true " +
            "ELSE false " +
            "END " +
            "FROM Agendamento a " +
            "WHERE (:id IS NULL AND a.data = :data AND a.hora = :hora) " +
            "OR (:id IS NOT NULL AND a.id <> :id AND a.data = :data AND a.hora = :hora)")
    boolean existsByDataEhora(Integer id, String data, String hora);
}
