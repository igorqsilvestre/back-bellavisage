package ads4.fatesg.pbbellavisage.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Usuario;
import ads4.fatesg.pbbellavisage.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class UsuarioService implements GenericOperations<Usuario, Integer> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario entity) {
        return usuarioRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario read(Integer id) {
        return usuarioRepository.getReferenceById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> readAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updatePart(Integer id, Usuario entity) {

        Usuario usuarioEncontrado = this.read(id);

        if(usuarioEncontrado != null){
            entity.setId(usuarioEncontrado.getId());
            return usuarioRepository.save(entity);
        }

        return new Usuario();
    }

    @Override
    public Usuario updateAll(Integer id, Usuario entity) {

        Usuario usuarioEncontrado = this.read(id);

        if(usuarioEncontrado != null){

            entity.setId(usuarioEncontrado.getId());
            return usuarioRepository.save(entity);
        }

        return new Usuario();
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
