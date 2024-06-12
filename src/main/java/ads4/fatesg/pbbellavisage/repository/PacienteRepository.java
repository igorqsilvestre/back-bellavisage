package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Paciente p WHERE p.cpf = :cpf")
    boolean existsByCPF(String cpf);
}
