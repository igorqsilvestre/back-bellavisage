package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {
    Optional<Tratamento> findByNome(String nome);
}
