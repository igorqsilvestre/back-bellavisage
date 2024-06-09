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

    @Column(name = "numero_registro", nullable = false, unique = true)
    private Integer numeroRegistro;

    @Column(name = "funcao", nullable = false)
    private String funcao;

    @JsonIgnore
    @OneToMany(mappedBy = "especialista", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

}
