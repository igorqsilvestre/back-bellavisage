package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "horario")
public class Horario extends BaseModel{

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "disponibilidade", nullable = false)
    private boolean disponibilidade;

    @ManyToOne
    @JoinColumn(name = "especialista_id", referencedColumnName = "id")
    private Especialista especialista;

    @ManyToOne
    @JoinColumn(name = "tratamento_id", referencedColumnName = "id")
    private Tratamento tratamento;

}
