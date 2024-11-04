package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente extends BaseModel{

    @Column(name = "nome", length = 100,nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column (name="senha", length = 16, nullable = false )
    private String senha;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "dataNascimento", length = 10, nullable = false)
    private Date dataNascimento;

    @JsonIgnoreProperties() // Evita recursão infinita
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

}
