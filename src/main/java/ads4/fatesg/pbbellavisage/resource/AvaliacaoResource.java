package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Avaliacao;
import ads4.fatesg.pbbellavisage.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/avaliacao")
public class AvaliacaoResource implements GenericOperations<Avaliacao, Integer> {

    @Autowired
    private AvaliacaoService avaliacaoService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Avaliacao create(@Valid @RequestBody Avaliacao entity) {
        return avaliacaoService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Avaliacao read(@PathVariable  Integer id) {
        return avaliacaoService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Avaliacao> readAll() {
        return avaliacaoService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Avaliacao updatePart(@PathVariable  Integer id, @Valid @RequestBody Avaliacao entity) {
        return avaliacaoService.updatePart(id,entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Avaliacao updateAll(@PathVariable Integer id, @Valid @RequestBody Avaliacao entity) {
        return avaliacaoService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        avaliacaoService.delete(id);
    }
}
