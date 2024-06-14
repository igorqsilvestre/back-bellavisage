package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EspecialistaRepository extends JpaRepository<Especialista, Integer> {
    Optional<Especialista> findByRegistro(Integer registro);
}
