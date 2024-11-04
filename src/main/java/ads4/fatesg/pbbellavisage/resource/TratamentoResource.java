package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Especialista;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import ads4.fatesg.pbbellavisage.service.EspecialistaService;
import ads4.fatesg.pbbellavisage.service.TratamentoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/tratamento")
public class TratamentoResource implements GenericOperations<Tratamento, Integer> {

    @Autowired
    private TratamentoService tratamentoService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento create(@Valid @RequestBody Tratamento entity) {

        // Converte a imagem de Base64 para byte[] antes de salvar
        entity.setImagemBase64(entity.getImagemBase64()); // Use o método setImagemBase64 para processar a imagem
        return tratamentoService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento read(@PathVariable  Integer id) {
        Tratamento tratamento = tratamentoService.read(id);
        // Converte a imagem para Base64 antes de retornar
        tratamento.setImagemBase64(Base64.getEncoder().encodeToString(tratamento.getImagem()));
        return tratamento;
    }

    @GetMapping(
            value = "/nome/{nome}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Tratamento readByRegistro(@PathVariable String nome) {
        Tratamento tratamento = tratamentoService.readByNome(nome);
        tratamento.setImagemBase64(Base64.getEncoder().encodeToString(tratamento.getImagem()));
        return tratamento;
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Tratamento> readAll() {
        List<Tratamento> tratamentos = tratamentoService.readAll();
        // Converte as imagens para Base64
        for (Tratamento tratamento : tratamentos) {
            tratamento.setImagemBase64(Base64.getEncoder().encodeToString(tratamento.getImagem()));
        }
        return tratamentos;
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento updatePart(@PathVariable  Integer id, @Valid @RequestBody Tratamento entity) {
        // Lê o tratamento atual
        Tratamento tratamentoAtual = tratamentoService.read(id);

        // Atualiza os campos
        if (entity.getNome() != null) {
            tratamentoAtual.setNome(entity.getNome());
        }
        if (entity.getValor() != null) {
            tratamentoAtual.setValor(entity.getValor());
        }
        if (entity.getDescricao() != null) {
            tratamentoAtual.setDescricao(entity.getDescricao());
        }
        if (entity.getFuncionamento() != null) {
            tratamentoAtual.setFuncionamento(entity.getFuncionamento());
        }
        if (entity.getIndicacoes() != null) {
            tratamentoAtual.setIndicacoes(entity.getIndicacoes());
        }
        // Converte a imagem de Base64 para byte[] se fornecida
        if (entity.getImagemBase64() != null) {
            tratamentoAtual.setImagem(Base64.getDecoder().decode(entity.getImagemBase64()));
        }

        return tratamentoService.updatePart(id, tratamentoAtual);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento updateAll(@PathVariable Integer id, @Valid @RequestBody Tratamento entity) {
        // O mesmo processo que no updatePart
        Tratamento tratamentoAtual = tratamentoService.read(id);

        // Atualiza todos os campos
        tratamentoAtual.setNome(entity.getNome());
        tratamentoAtual.setValor(entity.getValor());
        tratamentoAtual.setDescricao(entity.getDescricao());
        tratamentoAtual.setFuncionamento(entity.getFuncionamento());
        tratamentoAtual.setIndicacoes(entity.getIndicacoes());
        // Converte a imagem de Base64 para byte[] se fornecida
        tratamentoAtual.setImagem(Base64.getDecoder().decode(entity.getImagemBase64()));


        return tratamentoService.updateAll(id, tratamentoAtual);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        tratamentoService.delete(id);
    }
}
