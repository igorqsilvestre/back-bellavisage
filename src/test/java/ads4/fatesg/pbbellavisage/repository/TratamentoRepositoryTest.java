package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Endereco;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class TratamentoRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository ;

    @Autowired
    private TratamentoRepository tratamentoRepository;

    @Test
    @DisplayName("Retorna sucesso se encontrar o tratamento")
    void findByNomeCase1() {
        // Criação do tratamento
        Tratamento tratamento = new Tratamento();
        tratamento.setNome("Jato de plasma");
        tratamento.setDescricao("Tratamento de rugas, linhas de expressão, manchas escuras na pele, cicatrizes e principalmente flacidez de pálpebras");
        tratamento.setImagem("");
        tratamento.setValor(new BigDecimal("1600"));

        tratamentoRepository.save(tratamento);

        Optional<Tratamento> tratamentoEncontrado = tratamentoRepository.findByNome("Jato de plasma");
        assertTrue(tratamentoEncontrado.isPresent());

    }

    @Test
    @DisplayName("Retorna erro se encontrar o tratamento")
    void findByNomeCase2() {
        // Criação do tratamento
        Tratamento tratamento = new Tratamento();
        tratamento.setNome("Jato de plasma");
        tratamento.setDescricao("Tratamento de rugas, linhas de expressão, manchas escuras na pele, cicatrizes e principalmente flacidez de pálpebras");
        tratamento.setImagem("");
        tratamento.setValor(new BigDecimal("1600"));

        tratamentoRepository.save(tratamento);

        Optional<Tratamento> tratamentoEncontrado = tratamentoRepository.findByNome("Massagem");
        assertFalse(tratamentoEncontrado.isPresent());

    }
}