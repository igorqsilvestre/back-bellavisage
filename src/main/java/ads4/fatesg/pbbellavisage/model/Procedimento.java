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

    @Column(name = "valor",nullable = false)
    private BigDecimal valor;

    @Column(name = "descricao",nullable = false)
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "procedimento", fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos = new ArrayList<>();
}
