package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "agendamento")
public class Agendamento extends BaseModel{

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Column(name = "hora", nullable = false)
    private LocalDateTime hora;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "especialista_id", referencedColumnName = "id")
    private Especialista especialista;

    @ManyToOne
    @JoinColumn(name = "procedimento_id", referencedColumnName = "id")
    private Tratamento tratamento;

}
