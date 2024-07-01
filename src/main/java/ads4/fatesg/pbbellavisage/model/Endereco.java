package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "endereco")
public class Endereco extends BaseModel{

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade",nullable = false)
    private String cidade;

    @Column(name = "estado",nullable = false)
    private String estado;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @JsonIgnoreProperties("endereco") // Evita recursão infinita
    @OneToOne(mappedBy = "endereco")
    private Pessoa pessoa;

}
