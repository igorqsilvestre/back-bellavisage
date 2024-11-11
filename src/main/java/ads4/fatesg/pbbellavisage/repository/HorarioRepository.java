package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Especialista;
import ads4.fatesg.pbbellavisage.model.Horario;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query("SELECT h FROM Horario h WHERE h.tratamento.id = :idTratamento AND h.especialista.id = :idEspecialista AND FUNCTION('DATE', h.data) = FUNCTION('DATE', :data) AND h.disponibilidade = true")
    List<Horario> findAllByTratamentoAndEspecialistaAndData(
            @Param("idTratamento") Integer idTratamento,
            @Param("idEspecialista") Integer idEspecialista,
            @Param("data") Date data);

    @Query("SELECT h FROM Horario h WHERE h.tratamento.id = :idTratamento AND FUNCTION('DATE', h.data) = FUNCTION('DATE', :data) AND h.disponibilidade = true")
    List<Horario> findAllByTratamentoAndData(
            @Param("idTratamento") Integer idTratamento,
            @Param("data") Date data);

    @Query("DELETE FROM Horario h WHERE FUNCTION('DATE', h.data) < FUNCTION('DATE', :dataAtual) AND h.disponibilidade = true")
    @Modifying
    void deleteHorariosMenoresQueDataAtual(@Param("dataAtual") Date dataAtual);

}
