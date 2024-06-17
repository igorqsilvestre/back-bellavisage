package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Endereco;
import ads4.fatesg.pbbellavisage.model.Especialista;
import ads4.fatesg.pbbellavisage.model.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class EspecialistaRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository ;

    @Autowired
    private EspecialistaRepository especialistaRepository;

    @Test
    @DisplayName("Retorna erro se não encontrar o especialista")
    void findByRegistroCase1() {
        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("70444719");
        endereco.setCidade("Caldas Novas");
        endereco.setComplemento("");
        endereco.setEstado("Goiás");
        endereco.setNumero(81);
        endereco.setRua("São pedro");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        Especialista especialista = new Especialista();
        especialista.setNome("Dr joão");
        especialista.setRegistro(112);
        especialista.setEmail("drjoaohenrique@hotmail.com");
        especialista.setTelefone("63934411982");
        especialista.setEspecialidade("Médico");
        especialista.setEndereco(enderecoSalvo);

        especialistaRepository.save(especialista);

        Optional<Especialista> especialistaEncontrado = especialistaRepository.findByRegistro(01);
        assertThat(especialistaEncontrado.isPresent()).isFalse();

    }

    @Test
    @DisplayName("Retorna sucesso se encontrar o especialista")
    void findByRegistroCase2() {
        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("70444719");
        endereco.setCidade("Caldas Novas");
        endereco.setComplemento("");
        endereco.setEstado("Goiás");
        endereco.setNumero(81);
        endereco.setRua("São pedro");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        Especialista especialista = new Especialista();
        especialista.setNome("Dr joão");
        especialista.setRegistro(995);
        especialista.setEmail("drjoaohenrique@hotmail.com");
        especialista.setTelefone("63934411982");
        especialista.setEspecialidade("Médico");
        especialista.setEndereco(enderecoSalvo);

        especialistaRepository.save(especialista);

        Optional<Especialista> especialistaEncontrado = especialistaRepository.findByRegistro(995);
        assertThat(especialistaEncontrado.isPresent()).isTrue();

    }
}