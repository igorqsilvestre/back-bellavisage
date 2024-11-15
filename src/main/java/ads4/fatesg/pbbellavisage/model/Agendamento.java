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
@Table(name = "agendamento")
public class Agendamento extends BaseModel{


    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusAgendamento status;

    @Column(name = "avaliacao")
    private Integer avaliacao;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "especialista_id", referencedColumnName = "id")
    private Especialista especialista;

    @ManyToOne
    @JoinColumn(name = "tratamento_id", referencedColumnName = "id")
    private Tratamento tratamento;

    @OneToOne
    @JoinColumn(name = "horario_id", referencedColumnName = "id", nullable = false)
    private Horario horario;

    @JsonIgnore
    @OneToMany(mappedBy = "agendamento", fetch = FetchType.LAZY)
    private List<Pagamento> pagamentos = new ArrayList<>();


    public enum StatusAgendamento {
        Aberto, Concluido
    }
}
