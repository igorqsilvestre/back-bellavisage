package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Endereco;
import ads4.fatesg.pbbellavisage.model.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class PacienteRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository ;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    @DisplayName("Retorna sucesso se o paciente")
    void findByCpfCase1() {

        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("75666119");
        endereco.setCidade("Aparecida");
        endereco.setComplemento("Quadra 30, Lote 20");
        endereco.setEstado("Goiás");
        endereco.setNumero(11);
        endereco.setRua("Vila barbosa");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        // Criação do paciente
        Paciente paciente = new Paciente();

        paciente.setNome("Carlos");
        paciente.setCpf("76629815509");
        paciente.setEndereco(enderecoSalvo);
        paciente.setEmail("carlinm22@gmail.com");
        paciente.setTelefone("62988776601");

        pacienteRepository.save(paciente);

        Optional<Paciente> pacienteEncontrado = pacienteRepository.findByCpf("76629815509");
        assertThat(pacienteEncontrado.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Retorna erro se não encontrou o paciente")
    void findByCpfCase2() {

        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("75666119");
        endereco.setCidade("Aparecida");
        endereco.setComplemento("Quadra 30, Lote 20");
        endereco.setEstado("Goiás");
        endereco.setNumero(11);
        endereco.setRua("Vila barbosa");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        // Criação do paciente
        Paciente paciente = new Paciente();

        paciente.setNome("Carlos");
        paciente.setCpf("76629815509");
        paciente.setEndereco(enderecoSalvo);
        paciente.setEmail("carlinm22@gmail.com");
        paciente.setTelefone("62988776601");

        pacienteRepository.save(paciente);

        Optional<Paciente> pacienteEncontrado = pacienteRepository.findByCpf("111");
        assertThat(pacienteEncontrado.isPresent()).isFalse();
    }
}