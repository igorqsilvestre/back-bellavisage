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

    @Column(name = "numero_registro", length = 20, nullable = false, unique = true)
    private Integer numero_registro;

    @Column(name = "funcao", length = 100, nullable = false)
    private String funcao;

    @JsonIgnore
    @OneToMany(mappedBy = "especialista", fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos = new ArrayList<>();

}
