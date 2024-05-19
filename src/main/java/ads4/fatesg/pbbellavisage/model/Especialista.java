package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "especialista")
public class Especialista extends Pessoa{

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "numero_registro", length = 20, nullable = false)
    private Integer numeroRegistro;

    @Column(name = "funcao", length = 100, nullable = false)
    private String funcao;

    @OneToMany(mappedBy = "especialista")
    private List<Atendimento> atendimentos;
}
