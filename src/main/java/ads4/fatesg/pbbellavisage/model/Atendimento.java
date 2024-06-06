package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "atendimento")
public class Atendimento extends BaseModel{

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime data_hora;

    @Column(name = "nota", length = 10)
    private Integer nota;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "especialista_id", referencedColumnName = "id")
    private Especialista especialista;

    @ManyToOne
    @JoinColumn(name = "procedimento_id", referencedColumnName = "id")
    private Procedimento procedimento;

}
