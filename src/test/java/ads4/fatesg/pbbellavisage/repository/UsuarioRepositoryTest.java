package ads4.fatesg.pbbellavisage.repository;

import ads4.fatesg.pbbellavisage.model.Endereco;
import ads4.fatesg.pbbellavisage.model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository ;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Test
    @DisplayName("Retorna sucesso se encontrou o usuário com login e senha válidos")
    void existsByEmaileSenhaCase1() {

        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("74566120");
        endereco.setCidade("Goiânia");
        endereco.setComplemento("Quadra 38, Lote 11");
        endereco.setEstado("Goiás");
        endereco.setNumero(0);
        endereco.setLogradouro("Rua b");
        endereco.setBairro("Vila afonso");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        // Criação do usuário
        Usuario usuario = new Usuario();
        usuario.setPerfilsAcesso(Usuario.PerfilAcesso.Administrador);
        usuario.setSenha("btn123");
        usuario.setEmail("ffe@gmail.com");
        usuario.setEndereco(enderecoSalvo);
        usuario.setNome("Fernanda");
        usuario.setTelefone("62983886674");

        // Salva o usuário no banco de dados
        this.usuarioRepository.save(usuario);

        // Usando o método para verificar se existe usuário com login e senha
        boolean existe = usuarioRepository.existsByEmaileSenha("ffe@gmail.com", "btn123");
        assertThat(existe).isTrue();
    }

    @Test
    @DisplayName("Retorna erro se não encontrar o usuário com login ou senha inválidos")
    void existsByEmaileSenhaCase2() {

        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("74566120");
        endereco.setCidade("Goiânia");
        endereco.setComplemento("Quadra 38, Lote 11");
        endereco.setEstado("Goiás");
        endereco.setNumero(0);
        endereco.setLogradouro("Rua r");
        endereco.setBairro("Vila joao vaz");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        // Criação do usuário
        Usuario usuario = new Usuario();
        usuario.setPerfilsAcesso(Usuario.PerfilAcesso.Administrador);
        usuario.setSenha("btn123");
        usuario.setEmail("ffe@gmail.com");
        usuario.setEndereco(enderecoSalvo);
        usuario.setNome("Fernanda");
        usuario.setTelefone("62983886674");

        // Salva o usuário no banco de dados
        this.usuarioRepository.save(usuario);

        // Usando o método para verificar se existe usuário com login e senha
        boolean existe = usuarioRepository.existsByEmaileSenha("gg2@gmail.com", "btn123");
        assertThat(existe).isFalse();
    }


    @Test
    @DisplayName("Retorna erro se não encontrar o usuário. Passando um email inválido!")
    void existsByEmailCase1() {
        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("72553110");
        endereco.setCidade("Trindade");
        endereco.setComplemento("Quadra 1, Lote 5");
        endereco.setEstado("Goiás");
        endereco.setNumero(0);
        endereco.setBairro("Centro");
        endereco.setLogradouro("Avenida b");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        // Criação do usuário
        Usuario usuario = new Usuario();
        usuario.setPerfilsAcesso(Usuario.PerfilAcesso.Administrador);
        usuario.setSenha("998877");
        usuario.setEmail("jj12@email.com");
        usuario.setEndereco(enderecoSalvo);
        usuario.setNome("João guilherme");
        usuario.setTelefone("62981751291");

        // Salva o usuário no banco de dados
        this.usuarioRepository.save(usuario);

        // Usando o método para verificar se existe usuário com login e senha
        boolean existe = usuarioRepository.existsByEmail("xxwsdfsdf");
        assertThat(existe).isFalse();
    }

    @Test
    @DisplayName("Retorna sucesso se encontrar o usuário. Passando um email válido!")
    void existsByEmailCase2() {
        // Criação do endereço
        Endereco endereco = new Endereco();
        endereco.setCep("72553110");
        endereco.setCidade("Trindade");
        endereco.setComplemento("Quadra 1, Lote 5");
        endereco.setEstado("Goiás");
        endereco.setNumero(0);
        endereco.setBairro("Vila afonso");
        endereco.setLogradouro("Rua a");

        // Salva o endereço no banco de dados
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);

        // Criação do usuário
        Usuario usuario = new Usuario();
        usuario.setPerfilsAcesso(Usuario.PerfilAcesso.Administrador);
        usuario.setSenha("998877");
        usuario.setEmail("jj12@email.com");
        usuario.setEndereco(enderecoSalvo);
        usuario.setNome("João guilherme");
        usuario.setTelefone("62981751291");

        // Salva o usuário no banco de dados
        this.usuarioRepository.save(usuario);

        // Usando o método para verificar se existe usuário com login e senha
        boolean existe = usuarioRepository.existsByEmail("jj12@email.com");
        assertThat(existe).isTrue();
    }
}