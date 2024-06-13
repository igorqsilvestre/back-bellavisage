package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByCpf(String cpf);
}
