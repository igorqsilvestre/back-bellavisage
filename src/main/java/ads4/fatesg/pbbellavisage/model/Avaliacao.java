package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "avaliacao")
public class Avaliacao extends BaseModel{


    @Column(name = "nota", length = 10)
    private Integer nota;

    @Column(name = "comentario")
    private String comentario;

    @OneToMany(mappedBy = "avaliacao")
    private List<Atendimento> atendimentos;

}
