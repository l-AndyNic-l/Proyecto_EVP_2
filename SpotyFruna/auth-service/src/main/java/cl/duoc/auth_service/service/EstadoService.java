package cl.duoc.auth_service.service;

import cl.duoc.auth_service.model.Estado;
import cl.duoc.auth_service.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;



    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado findByNombre(String nombre) {
        return estadoRepository.findByNombre(nombre);
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado update(Long idEstado, Estado estadoNuevo) {
        if (estadoRepository.existsById(idEstado)) {
            Estado estado = estadoRepository.findById(idEstado).orElse(null);

            estado.setNombre(estadoNuevo.getNombre());

            return estadoRepository.save(estado);
        } else  {
            return null;
        }
    }

    public Boolean deleteById(Long idEstado) {
        if (estadoRepository.existsById(idEstado)) {
            estadoRepository.deleteById(idEstado);
            return true;
        } else {
            return false;
        }
    }

}
