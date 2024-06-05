package ads4.fatesg.pbbellavisage.mapper;

import ads4.fatesg.pbbellavisage.dto.PessoaCreateDto;
import ads4.fatesg.pbbellavisage.model.Pessoa;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {


    public Pessoa converteDtoParaPessoa(@org.jetbrains.annotations.NotNull PessoaCreateDto pessoaDto){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDto.getNome());
        pessoa.setTipo_pessoa(pessoaDto.getTipo_pessoa());
        pessoa.setImagem(pessoaDto.getImagem());
        pessoa.setSexo(pessoaDto.getSexo());
        return pessoa;
    }
}
