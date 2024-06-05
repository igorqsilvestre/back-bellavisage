package ads4.fatesg.pbbellavisage.dto;

import ads4.fatesg.pbbellavisage.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaCreateDto {
    private String nome;
    private Pessoa.TipoPessoa tipo_pessoa;
    private String imagem;
    private Pessoa.TipoSexo sexo;

}
