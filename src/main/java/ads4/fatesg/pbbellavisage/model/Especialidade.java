package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "especialidade")
public class Especialidade extends BaseModel{

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;


}
