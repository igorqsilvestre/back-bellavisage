package ads4.fatesg.pbbellavisage.model;

import ads4.fatesg.pbbellavisage.dto.PessoaCreateDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa extends BaseModel{

    @Column(name = "tipo_pessoa", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo_pessoa;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "imagem")
    private String imagem;

    @Column(name = "sexo", length = 10)
    @Enumerated(EnumType.STRING)
    private TipoSexo sexo;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agendamento> agendamentos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Especialidade> especialidades = new ArrayList<>();


    public enum TipoSexo{
        masculino,
        feminino
    }

    public enum TipoPessoa{
        paciente,
        admin,
        especialista
    }

}
