package ads4.fatesg.pbbellavisage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @Column(name = "imagem", nullable = false, columnDefinition = "TEXT")
    private byte[] imagem;

    @JsonIgnore
    @OneToMany(mappedBy = "tratamento", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();


    // Método para obter a imagem como Base64
    public String getImagemBase64() {
        if (imagem != null) {
            return Base64.getEncoder().encodeToString(imagem);
        }
        return null;
    }

    // Método para definir a imagem a partir de uma string Base64
    public void setImagemBase64(String imagemBase64) {
        if (imagemBase64 != null) {
            // Verifica se a string contém o prefixo e remove
            if (imagemBase64.startsWith("data:image/")) {
                // Divide a string para pegar apenas a parte Base64
                imagemBase64 = imagemBase64.split(",")[1]; // Obtém a parte após a vírgula
            }
            this.imagem = Base64.getDecoder().decode(imagemBase64); // Decodifica a Base64
        } else {
            this.imagem = null;
        }
    }
}
