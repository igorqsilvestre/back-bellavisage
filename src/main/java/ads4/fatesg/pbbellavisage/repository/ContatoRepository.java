package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Contato;
import ads4.fatesg.pbbellavisage.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
