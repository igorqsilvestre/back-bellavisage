package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.dto.LoginDto;
import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Paciente;
import ads4.fatesg.pbbellavisage.service.PacienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/paciente")
public class PacienteResource implements GenericOperations<Paciente, Integer> {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/ping")
    public boolean ping() {
        return true;
    }


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Paciente create(@Valid @RequestBody Paciente entity) {
        return pacienteService.create(entity);
    }

    @PostMapping(
            value = "/logar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean existsLogin(@RequestBody LoginDto request) {
        String email = request.getEmail();
        String senha = request.getSenha();
        return pacienteService.existsPaciente(email,senha);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Paciente read(@PathVariable  Integer id) {
        return pacienteService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Paciente> readAll() {
        return pacienteService.readAll();
    }

    @GetMapping(
            value = "/cpf/{cpf}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Paciente readByCPF(@PathVariable String cpf) {
        return pacienteService.readByCPF(cpf);

    }

    @GetMapping(
            value = "/email/{email}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Paciente readByEmail(@PathVariable String email) {
        return pacienteService.readByEmail(email);

    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Paciente updatePart(@PathVariable  Integer id, @Valid @RequestBody Paciente entity) {
        return pacienteService.updatePart(id,entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Paciente updateAll(@PathVariable Integer id, @Valid @RequestBody Paciente entity) {
        return pacienteService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        pacienteService.delete(id);
    }
}
