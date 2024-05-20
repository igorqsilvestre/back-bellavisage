package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa{

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos = new ArrayList<>();


}
