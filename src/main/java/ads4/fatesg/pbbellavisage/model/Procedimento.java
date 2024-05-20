package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "procedimento")
public class Procedimento extends BaseModel{

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "valor",nullable = false)
    private BigDecimal valor;

    @Column(name = "descricao",nullable = false)
    private String descricao;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Atendimento atendimento;
}
