package ads4.fatesg.pbbellavisage.model;

import jakarta.persistence.*;

public class Endereco {

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "numero")
    private int numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cidade",nullable = false)
    private String cidade;

    @Column(name = "estado",nullable = false)
    private String estado;

    @OneToOne(mappedBy = "endereco")
    private Usuario usuario;
}
