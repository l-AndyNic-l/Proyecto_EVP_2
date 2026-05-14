package cl.duoc.playlists_service.service;

import cl.duoc.playlists_service.model.GuardarCancion;
import cl.duoc.playlists_service.repository.GuardarCancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GuardarCancionService {

    @Autowired
    private GuardarCancionRepository guardarCancionRepository;



    public List<GuardarCancion> findAll() {
        return guardarCancionRepository.findAll();
    }

    public Optional<GuardarCancion> findById(Long idGuardarCancion) {
        return guardarCancionRepository.findById(idGuardarCancion);
    }

    public GuardarCancion save(GuardarCancion guardarCancion) {
        return guardarCancionRepository.save(guardarCancion);
    }

    public GuardarCancion update(Long idGuardarCancion, GuardarCancion guardarCancionNueva) {
        if (guardarCancionRepository.existsById(idGuardarCancion)) {
            GuardarCancion playlistCancion = guardarCancionRepository.findById(idGuardarCancion).orElse(null);

            playlistCancion.setPlaylist(guardarCancionNueva.getPlaylist());
            playlistCancion.setIdCancion(guardarCancionNueva.getIdCancion());

            return guardarCancionRepository.save(playlistCancion);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idGuardarCancion) {
        if (guardarCancionRepository.existsById(idGuardarCancion)) {
            guardarCancionRepository.deleteById(idGuardarCancion);
            return true;
        } else {
            return false;
        }
    }

}
