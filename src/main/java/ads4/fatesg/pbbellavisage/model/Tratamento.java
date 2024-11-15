package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Data
@Entity
@Table(name = "tratamento")
public class Tratamento extends BaseModel{

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "valor",     nullable = false)
    private BigDecimal valor;

    @Lob
    @Column(name = "descricao",nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Lob
    @Column(name = "funcionamento",nullable = false, columnDefinition = "TEXT")
        private String funcionamento;

    @Lob
    @Column(name = "indicacoes",nullable = false, columnDefinition = "TEXT")
    private String indicacoes;

    @Lob
    @Column(name = "imagem", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] imagem;

    @Column(name = "tipoImagem", length = 100)
    private String tipoImagem;

    @JsonIgnore
    @OneToMany(mappedBy = "tratamento", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tratamento", fetch = FetchType.LAZY)
    private List<Horario> horarios = new ArrayList<>();

}
