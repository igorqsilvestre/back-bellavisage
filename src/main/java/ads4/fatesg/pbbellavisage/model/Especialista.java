package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "especialista")
public class Especialista extends Pessoa{

    @Column(name = "registro", nullable = false, unique = true)
    private Integer registro;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "especialista_tratamento",
            joinColumns = @JoinColumn(name = "especialista_id"),
            inverseJoinColumns = @JoinColumn(name = "tratamento_id")
    )
    private List<Tratamento> tratamentos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "especialista", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

}
