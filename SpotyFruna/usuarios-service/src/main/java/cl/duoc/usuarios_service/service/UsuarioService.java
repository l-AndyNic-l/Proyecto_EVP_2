package cl.duoc.usuarios_service.service;

import cl.duoc.usuarios_service.model.Usuario;
import cl.duoc.usuarios_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario u) {
        if(u.getTipo().equalsIgnoreCase("Cliente") || u.getTipo().equalsIgnoreCase("Artista")) {
            return usuarioRepository.save(u);
        } else {
            return null;
        }
    }

    public int update(Usuario u, Long id) {
        if(u.getTipo().equalsIgnoreCase("Cliente") || u.getTipo().equalsIgnoreCase("Artista")) {
            return usuarioRepository.update(u, id);
        } else {
            return 0;
        }
    }

    public Boolean deleteById(Long id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
