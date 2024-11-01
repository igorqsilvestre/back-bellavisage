package ads4.fatesg.pbbellavisage.dto;

import ads4.fatesg.pbbellavisage.model.Agendamento;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Setter
@Getter
public class PagamentoCreateDto {
    private Integer id;
    private Integer agendamento;
    private Date dataHorario;
    private BigDecimal valor;
    @NotNull
    private String formaDePagamento;
    @NotNull
    private String statusPagamento;

}
