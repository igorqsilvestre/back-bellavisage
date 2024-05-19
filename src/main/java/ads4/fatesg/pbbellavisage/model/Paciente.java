package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa{

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @OneToMany(mappedBy = "paciente")
    private List<Atendimento> atendimentos;

}
