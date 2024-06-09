package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Agendamento;
import ads4.fatesg.pbbellavisage.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/agendamento")
public class AgendamentoResource implements GenericOperations<Agendamento, Integer> {

    @Autowired
    private AgendamentoService agendamentoService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento create(@Valid @RequestBody Agendamento entity) {
        return agendamentoService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento read(@PathVariable  Integer id) {
        return agendamentoService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Agendamento> readAll() {
        return agendamentoService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento updatePart(@PathVariable  Integer id, @Valid @RequestBody Agendamento entity) {
        return agendamentoService.updatePart(id,entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento updateAll(@PathVariable Integer id, @Valid @RequestBody Agendamento entity) {
        return agendamentoService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        agendamentoService.delete(id);
    }
}
