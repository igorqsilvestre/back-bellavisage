package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Paciente;
import ads4.fatesg.pbbellavisage.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class PacienteService implements GenericOperations<Paciente, Integer> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente create(Paciente entity) {
        return pacienteRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente read(Integer id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> readAll() {
        return pacienteRepository.findAll();
    }


    @Transactional(readOnly = true)
    public boolean existsCPF(String cpf) {
        return pacienteRepository.existsByCPF(cpf);
    }


    @Override
    public Paciente updatePart(Integer id, Paciente entity) {

        Paciente pacienteEncontrado = this.read(id);

        if(pacienteEncontrado != null){

            entity.getEndereco().setId(pacienteEncontrado.getEndereco().getId());
            entity.setId(pacienteEncontrado.getId());
            return pacienteRepository.save(entity);
        }

        return new Paciente();
    }

    @Override
    public Paciente updateAll(Integer id, Paciente entity) {

        Paciente pacienteEncontrado = this.read(id);

        if(pacienteEncontrado != null){
            entity.getEndereco().setId(pacienteEncontrado.getEndereco().getId());
            entity.setId(pacienteEncontrado.getId());
            return pacienteRepository.save(entity);
        }

        return new Paciente();
    }

    @Override
    public void delete(Integer id) {
        pacienteRepository.deleteById(id);
    }



}
