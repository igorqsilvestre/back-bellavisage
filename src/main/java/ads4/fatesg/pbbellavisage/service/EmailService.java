package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Email;
import ads4.fatesg.pbbellavisage.repository.EmailRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class EmailService implements GenericOperations<Email, Integer> {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public Email create(Email entity) {
        return emailRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Email read(Integer id) {
        return emailRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Email não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Email> readAll() {
        return emailRepository.findAll();
    }

    @Override
    public Email updatePart(Integer id, Email entity) {
        Email emailEncontrado = this.read(id);

        if(emailEncontrado != null){
            entity.setId(emailEncontrado.getId());
            return emailRepository.save(entity);
        }

        return new Email();
    }

    @Override
    public Email updateAll(Integer id, Email entity) {
        Email emailEncontrado = this.read(id);

        if(emailEncontrado != null){
            entity.setId(emailEncontrado.getId());
            return emailRepository.save(entity);
        }

        return new Email();
    }

    @Override
    public void delete(Integer id) {
        emailRepository.deleteById(id);
    }

}
