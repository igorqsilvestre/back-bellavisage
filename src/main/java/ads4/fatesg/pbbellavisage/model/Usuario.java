package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa{

    @Column(name = "senha", length = 8, nullable = false )
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfilAcesso", length = 20, nullable = false )
    private PerfilAcesso perfilAcesso;

    public enum PerfilAcesso {
        ADMINISTRADOR, USUARIO
    }
}
