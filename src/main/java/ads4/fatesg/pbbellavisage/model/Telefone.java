package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "telefone")
public class Telefone extends BaseModel {

    @Column(name = "ddd", length = 2, nullable = false)
    private String ddd;

    @Column(name = "numero", length = 20, nullable = false)
    private String numero;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contato_id", nullable = false)
    private Contato contato;


}
