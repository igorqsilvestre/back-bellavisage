package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "agendamento")
public class Agendamento extends BaseModel{

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

}
