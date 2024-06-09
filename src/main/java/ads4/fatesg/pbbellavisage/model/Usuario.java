package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa{

    @Column(name = "senha", length = 16, nullable = false )
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfilsAcesso", length = 20, nullable = false )
    private PerfilAcesso perfilsAcesso;


    public enum PerfilAcesso {
        Administrador, Cliente
    }
}
