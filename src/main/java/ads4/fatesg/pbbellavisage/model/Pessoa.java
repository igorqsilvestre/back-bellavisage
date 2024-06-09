package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends BaseModel{

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    @JsonIgnoreProperties("pessoa") // Evita recursão infinita
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

}
