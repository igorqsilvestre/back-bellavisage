package ads4.fatesg.pbbellavisage.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class AgendamentoCreateDto {
    private Integer id;
    @NotNull
    private String data;
    @NotNull
    private String hora;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Integer paciente;
    @NotNull
    private Integer especialista;
    @NotNull
    private Integer tratamento;
    private String status;
    private Integer avaliacao;
}
