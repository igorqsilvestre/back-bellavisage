package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "procedimento")
public class Procedimento extends BaseModel{

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao",nullable = false)
    private String descricao;

    @Column(name = "preco",nullable = false)
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "agendamento_id", nullable = false)
    private Agendamento agendamento;
}
