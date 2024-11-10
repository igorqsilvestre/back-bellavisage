package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.dto.HorarioCreateDto;
import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Especialista;
import ads4.fatesg.pbbellavisage.model.Horario;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import ads4.fatesg.pbbellavisage.service.EspecialistaService;
import ads4.fatesg.pbbellavisage.service.HorarioService;
import ads4.fatesg.pbbellavisage.service.TratamentoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/horario")
public class HorarioResource implements GenericOperations<Horario, Integer> {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private EspecialistaService especialistaService;

    @Autowired
    private TratamentoService tratamentoService;



    @Override
    public Horario create(@Valid @RequestBody Horario entity) {
        return horarioService.create(entity);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Horario createHorarioComDto(@Valid @RequestBody HorarioCreateDto dto){
        Horario horario = converteDtoEmHorario(dto);
        return horarioService.create(horario);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Horario read(@PathVariable  Integer id) {
        return horarioService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Horario> readAll() {
        return horarioService.readAll();
    }

    @GetMapping(
            value = "/tratamento/{idTratamento}/especialista/{idEspecialista}/data/{data}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Horario> readAllByTratamentoAndEspecialistaAndData(@PathVariable Integer idTratamento,
                                                                   @PathVariable Integer idEspecialista,
                                                                   @PathVariable Date data){

        return horarioService.readAllByTratamentoAndEspecialistaAndData(idTratamento, idEspecialista, data);
    }

    @GetMapping(
            value = "/tratamento/{idTratamento}/data/{data}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Horario> readAllByTratamentoAndData(@PathVariable Integer idTratamento, @PathVariable Date data){
        return horarioService.readAllByTratamentoAndData(idTratamento, data);
    }


    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Horario updatePart(@PathVariable  Integer id, @Valid @RequestBody Horario entity) {
        return horarioService.updatePart(id,entity);
    }

    @PatchMapping(
            value = "/{id}/disponibilidade",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean updateDisponibilidade(@PathVariable Integer id,
                                         @RequestBody boolean disponibilidade) {
        return horarioService.updateDisponibilidade(id,disponibilidade);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Horario updateAll(@PathVariable Integer id, @Valid @RequestBody Horario entity) {
        return horarioService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        horarioService.delete(id);
    }

    @DeleteMapping(
            value = "/deletarHorariosAntigos"
    )
    public void delete() {
        this.horarioService.deleteHorariosMenoresQueDataAtual(new Date());
    }


    private Horario converteDtoEmHorario(HorarioCreateDto dto) {
        Especialista especialista = especialistaService.read(dto.getEspecialista());
        Tratamento tratamento = tratamentoService.read(dto.getTratamento());

        Horario horario = new Horario();
        horario.setId(dto.getId());
        horario.setTratamento(tratamento);
        horario.setEspecialista(especialista);
        horario.setData(dto.getData());
        horario.setDisponibilidade(dto.getDisponibilidade());
        return horario;
    }
}
