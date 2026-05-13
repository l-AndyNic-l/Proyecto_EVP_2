package cl.duoc.playlists_service.service;

import cl.duoc.playlists_service.clients.CancionClient;
import cl.duoc.playlists_service.model.GuardarCancion;
import cl.duoc.playlists_service.repository.PlaylistCancionRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistCancionService {

    @Autowired
    private PlaylistCancionRepository playlistCancionRepository;

    public List<GuardarCancion> findAll() {
        return playlistCancionRepository.findAll();
    }

    public Optional<GuardarCancion> findById(Long id) {
        return playlistCancionRepository.findById(id);
    }

    public GuardarCancion save(GuardarCancion pC) {
        return playlistCancionRepository.save(pC);
    }

    public GuardarCancion update(Long id, GuardarCancion pC) {
        if (playlistCancionRepository.existsById(id)) {
            GuardarCancion playlistCancion = playlistCancionRepository.findById(id).orElse(null);
            playlistCancion.setPlaylist(pC.getPlaylist());
            playlistCancion.setIdCancion(pC.getIdCancion());
            return playlistCancionRepository.save(playlistCancion);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if (playlistCancionRepository.existsById(id)) {

            playlistCancionRepository.deleteById(id);
            return true;

        } else {
            return false;
        }
    }

}
