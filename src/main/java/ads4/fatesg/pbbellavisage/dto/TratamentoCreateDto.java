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
    private String tipoImagem;


    public Tratamento criaTratamentoApartirDoDTO(){
        Tratamento tratamento = new Tratamento();
        tratamento.setNome(this.getNome());
        tratamento.setValor(this.getValor());
        tratamento.setDescricao(this.getDescricao());
        tratamento.setFuncionamento(this.getFuncionamento());
        tratamento.setIndicacoes(this.getIndicacoes());
        tratamento.setImagem(converteImagemParaByteDeBase64(this.getImagem()));
        tratamento.setTipoImagem(pegaTipoImagemDeBase64(this.getImagem()));
        return tratamento;
    }

    private String pegaTipoImagemDeBase64(String imagemBase64){
        String [] imagemSeparada = this.separaImagemEtipoBase64(imagemBase64);
        if(imagemSeparada[0] == null || imagemSeparada[0].isBlank()){
            return null;
        }else{
            return imagemSeparada[0];
        }
    }


    private byte[] converteImagemParaByteDeBase64(String imagemBase64) {
        String [] imagemSeparada = this.separaImagemEtipoBase64(imagemBase64);
        if(imagemSeparada[1] == null || imagemSeparada[1].isBlank()){
            return null;
        }else{
            return Base64.getDecoder().decode(imagemSeparada[1]); // Decodifica a Base64
        }
    }

    private String[] separaImagemEtipoBase64(String imagemBase64){
        if (imagemBase64 != null) {
            if (imagemBase64.contains("base64")) {
                return imagemBase64.split("base64,");
            }
        }
        return null;
    }
}
