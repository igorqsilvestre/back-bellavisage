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
@Table(name = "especialista")
public class Especialista extends BaseModel{

    @Column(name = "nome", length = 100,nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "registro", nullable = false, unique = true)
    private Integer registro;

    @Column(name = "dataNascimento", length = 10, nullable = false)
    private Date dataNascimento;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @JsonIgnoreProperties() // Evita recursão infinita
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "especialista", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

}
