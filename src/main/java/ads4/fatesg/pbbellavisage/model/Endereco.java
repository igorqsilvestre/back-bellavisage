package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "endereco")
public class Endereco extends BaseModel{

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "uf",length = 2, nullable = false)
    private String uf;

    @Column(name = "numero")
    private int numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contato_id", nullable = false)
    private Contato contato;

}
