package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Especialidade;
import ads4.fatesg.pbbellavisage.service.EspecialidadeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/especialidade")
public class EspecialidadeResource implements GenericOperations<Especialidade, Integer> {

    @Autowired
    private EspecialidadeService especialidadeService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Especialidade create(@Valid @RequestBody Especialidade entity) {
        return especialidadeService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Especialidade read(@PathVariable  Integer id) {
        return especialidadeService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Especialidade> readAll() {
        return especialidadeService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Especialidade updatePart(@PathVariable  Integer id, @Valid @RequestBody Especialidade entity) {
        return especialidadeService.updatePart(id,entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Especialidade updateAll(@PathVariable Integer id, @Valid @RequestBody Especialidade entity) {
        return especialidadeService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        especialidadeService.delete(id);
    }
}
