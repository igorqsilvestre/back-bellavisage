package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Email;
import ads4.fatesg.pbbellavisage.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
}
