package cl.duoc.usuarios_service.service;

import cl.duoc.usuarios_service.model.TipoUsuario;
import cl.duoc.usuarios_service.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;



    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuario findByNombre(String nombre) {
        return tipoUsuarioRepository.findByNombre(nombre);
    }

    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public TipoUsuario update(Long idTipoUsuario, TipoUsuario tipoUsuarioNuevo) {
        if (tipoUsuarioRepository.existsById(idTipoUsuario)) {
            TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(idTipoUsuario).orElse(null);
            tipoUsuario.setNombre(tipoUsuarioNuevo.getNombre());

            return tipoUsuarioRepository.save(tipoUsuario);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idTipoUsuario) {
        if (tipoUsuarioRepository.existsById(idTipoUsuario)) {
            tipoUsuarioRepository.deleteById(idTipoUsuario);
            return true;
        } else {
            return false;
        }
    }

}
