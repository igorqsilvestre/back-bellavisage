package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "agendamento")
public class Agendamento extends BaseModel{

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

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
