package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Paciente;
import ads4.fatesg.pbbellavisage.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
