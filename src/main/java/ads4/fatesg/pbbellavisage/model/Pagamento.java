package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "pagamento")
public class Pagamento extends BaseModel{

    @Column(name = "data_horario")
    private Date dataHorario;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "formaDePagamento", nullable = false)
    private String formaDePagamento;

    @Column(name = "statusPagamento")
    private String statusPagamento;

    @ManyToOne
    @JoinColumn(name = "agendamento_id", referencedColumnName = "id")
    private Agendamento agendamento;

}
