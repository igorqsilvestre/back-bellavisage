package ads4.fatesg.pbbellavisage.dto;

import ads4.fatesg.pbbellavisage.model.Tratamento;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Base64;


@Setter
@Getter
public class TratamentoResponseDto {
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

    public TratamentoResponseDto(){}

    public TratamentoResponseDto criaTratamentoDtoApartirDoTratamento(Tratamento tratamento){
        TratamentoResponseDto tratamentoResponseDto = new TratamentoResponseDto();
        tratamentoResponseDto.setId(tratamento.getId());
        tratamentoResponseDto.setNome(tratamento.getNome());
        tratamentoResponseDto.setValor(tratamento.getValor());
        tratamentoResponseDto.setDescricao(tratamento.getDescricao());
        tratamentoResponseDto.setFuncionamento(tratamento.getFuncionamento());
        tratamentoResponseDto.setIndicacoes(tratamento.getIndicacoes());
        tratamentoResponseDto.setImagem(converteImagemParaBase64DeByte(tratamento.getImagem()));
        return tratamentoResponseDto;
    }

    public String converteImagemParaBase64DeByte(byte[] imagemByte) {
        if (imagemByte != null) {
            return Base64.getEncoder().encodeToString(imagemByte);
        }
        return null;
    }

}
