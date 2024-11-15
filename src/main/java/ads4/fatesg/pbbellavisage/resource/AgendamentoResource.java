package ads4.fatesg.pbbellavisage.resource;

import ads4.fatesg.pbbellavisage.dto.AgendamentoCreateDto;
import ads4.fatesg.pbbellavisage.dto.TratamentoResponseDto;
import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.*;
import ads4.fatesg.pbbellavisage.service.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/agendamento")
public class AgendamentoResource implements GenericOperations<Agendamento, Integer> {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EspecialistaService especialistaService;

    @Autowired
    private TratamentoService tratamentoService;

    @Autowired
    private HorarioService horarioService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Agendamento createAgendamentoComDto(@Valid @RequestBody AgendamentoCreateDto entity) {
        Agendamento agendamento = converteDtoEmAgendamento(entity);
        agendamento.setStatus(Agendamento.StatusAgendamento.Aberto);
        horarioService.updateDisponibilidade(agendamento.getHorario().getId(), false);
        return agendamentoService.create(agendamento);
    }

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


    @GetMapping(value = "/paciente/{pacienteId}/status",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Agendamento>readAllAgendamentosByPacienteIdAndStatus(@PathVariable Integer pacienteId, @RequestParam String status) {
        Agendamento.StatusAgendamento statusAgendamento = Agendamento.StatusAgendamento.valueOf(status);
        return agendamentoService.readAllAgendamentosByPacienteIdAndStatus(pacienteId, statusAgendamento);
    }

    @GetMapping(value = "/paciente/{pacienteId}/status/data",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Agendamento>readAllAgendamentosByPacienteIdStatusAndDate(@PathVariable Integer pacienteId,
                                                                         @RequestParam String status,
                                                                         @RequestParam String data) throws ParseException {
        Agendamento.StatusAgendamento statusAgendamento = Agendamento.StatusAgendamento.valueOf(status);
        // Converter String para java.util.Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Formato esperado da data
        Date dataAgendamento = format.parse(data); // Converte a String para Date
        return agendamentoService.readAllAgendamentosByPacienteIdStatusAndDate(pacienteId, statusAgendamento,dataAgendamento);
    }

    @GetMapping("/buscar")
    public List<Agendamento> readAllByNomeTratamentoStartingWithAndStatus(@RequestParam String nome, @RequestParam String status) {
        Agendamento.StatusAgendamento statusAgendamento = Agendamento.StatusAgendamento.valueOf(status);
        List<Agendamento> agendamentos = agendamentoService.readAllByNomeTratamentoStartingWithAndStatus(nome, statusAgendamento);
        return agendamentos;
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
    public Agendamento atualizaAgendamentoComDto(@PathVariable Integer id, @Valid @RequestBody AgendamentoCreateDto entity) {
        Agendamento agendamento = converteDtoEmAgendamento(entity);
        agendamento.setStatus(Agendamento.StatusAgendamento.valueOf(entity.getStatus()));
        agendamento.setAvaliacao(entity.getAvaliacao());
        return agendamentoService.updateAll(id, agendamento);
    }

    @Override
    public Agendamento updateAll(@PathVariable Integer id, @Valid @RequestBody Agendamento entity) {
        return agendamentoService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        Agendamento agendamento = agendamentoService.read(id);
        horarioService.updateDisponibilidade(agendamento.getHorario().getId(), true);
        agendamentoService.delete(agendamento.getId());
    }

    private Agendamento converteDtoEmAgendamento(@RequestBody @Valid AgendamentoCreateDto entity) {
        Paciente paciente = pacienteService.read(entity.getPaciente());
        Especialista especialista = especialistaService.read(entity.getEspecialista());
        Tratamento tratamento = tratamentoService.read(entity.getTratamento());
        Horario horario = horarioService.read(entity.getHorario());

        Agendamento agendamento = new Agendamento();
        agendamento.setId(entity.getId());
        agendamento.setValor(entity.getValor());
        agendamento.setHorario(horario);
        agendamento.setPaciente(paciente);
        agendamento.setEspecialista(especialista);
        agendamento.setTratamento(tratamento);
        return agendamento;
    }
}
