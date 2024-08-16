package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {


    @Query("SELECT COUNT(a) > 0 " +
            "FROM Agendamento a " +
            "WHERE a.especialista.id = :especialistaId " +
            "AND ((:id IS NULL AND DATE_FORMAT(a.dataHorario, '%Y-%m-%d %H:%i') = DATE_FORMAT(:dataHorario, '%Y-%m-%d %H:%i')) " +
            "OR (:id IS NOT NULL AND a.id <> :id AND DATE_FORMAT(a.dataHorario, '%Y-%m-%d %H:%i') = DATE_FORMAT(:dataHorario, '%Y-%m-%d %H:%i')))")
    boolean existsByDataEhoraAndEspecialista(@Param("id") Integer id,
                                             @Param("dataHorario") Date dataHorario,
                                             @Param("especialistaId") Integer especialistaId);
}
