package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario extends BaseModel {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "senha", length = 8, nullable = false )
    private String senha;

    @Column(name = "telefone", length = 30, nullable = false)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}
