package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.dto.TratamentoCreateDto;
import ads4.fatesg.pbbellavisage.dto.TratamentoResponseDto;
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

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/tratamento")
public class TratamentoResource {

    @Autowired
    private TratamentoService tratamentoService;

    @GetMapping("/ping")
    public boolean ping() {
        return true;
    }


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Tratamento createDto(@Valid @RequestBody TratamentoCreateDto dto) {
        Tratamento tratamento = dto.criaTratamentoApartirDoDTO();
        return tratamentoService.create(tratamento);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public TratamentoResponseDto read(@PathVariable  Integer id) {
        Tratamento tratamento = tratamentoService.read(id);
        return new TratamentoResponseDto().criaTratamentoDtoApartirDoTratamento(tratamento);
    }



    @GetMapping(
            value = "/nome/{nome}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public TratamentoResponseDto readByRegistro(@PathVariable String nome) {
        Tratamento tratamento = tratamentoService.readByNome(nome);
        return new TratamentoResponseDto().criaTratamentoDtoApartirDoTratamento(tratamento);
    }

    @GetMapping("/buscar")
    public List<TratamentoResponseDto> readAllByNomeStartingWith(@RequestParam String nome) {
        List<Tratamento> tratamentos = tratamentoService.readAllByNomeStartingWith(nome);
        List<TratamentoResponseDto> tratamentosDto = new ArrayList<>();

        for (Tratamento tratamento : tratamentos) {
            tratamentosDto.add(new TratamentoResponseDto().criaTratamentoDtoApartirDoTratamento(tratamento));
        }
        return tratamentosDto;
    }


    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<TratamentoResponseDto> readAll() {
        List<Tratamento> tratamentos = tratamentoService.readAll();
        List<TratamentoResponseDto> tratamentosDto = new ArrayList<>();

        for (Tratamento tratamento : tratamentos) {
           tratamentosDto.add(new TratamentoResponseDto().criaTratamentoDtoApartirDoTratamento(tratamento));
        }
        return tratamentosDto;
    }


    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Tratamento updateAll(@PathVariable Integer id, @Valid @RequestBody TratamentoCreateDto entity) {
        Tratamento tratamentoAtual = tratamentoService.read(id);
        return tratamentoService.updateAll(id, entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public void delete(@PathVariable Integer id) {
        tratamentoService.delete(id);
    }
}
