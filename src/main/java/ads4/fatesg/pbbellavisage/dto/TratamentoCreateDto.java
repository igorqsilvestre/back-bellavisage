package ads4.fatesg.pbbellavisage.dto;

import ads4.fatesg.pbbellavisage.model.Tratamento;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Base64;


@Setter
@Getter
public class TratamentoCreateDto {
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private String descricao;
    @NotNull
    private String funcionamento;
    @NotNull
    private String indicacoes;
    @NotNull
    private String imagem;


    public Tratamento criaTratamentoApartirDoDTO(){
        Tratamento tratamento = new Tratamento();
        tratamento.setNome(this.getNome());
        tratamento.setValor(this.getValor());
        tratamento.setDescricao(this.getDescricao());
        tratamento.setFuncionamento(this.getFuncionamento());
        tratamento.setIndicacoes(this.getIndicacoes());
        tratamento.setImagem(converteImagemParaByteDeBase64(this.getImagem()));
        return tratamento;
    }


    private byte[] converteImagemParaByteDeBase64(String imagemBase64) {
        if (imagemBase64 != null) {
            if(imagemBase64.contains("base64")){
                imagemBase64 = imagemBase64.split("base64,")[1];
            }
            return Base64.getDecoder().decode(imagemBase64); // Decodifica a Base64
        }
        return null;
    }


      /*
    public String converteImagemParaBase64DeByte(String imagemByte) {
        if (this.imagem != null) {
            return Base64.getEncoder().encodeToString(this.imagem);
        }
        return null;
    }
    */
}
