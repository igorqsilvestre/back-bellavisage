package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario extends BaseModel{

    @Column(name = "nome", length = 100,nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column (name="senha", length = 16, nullable = false )
    private String senha;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

}
