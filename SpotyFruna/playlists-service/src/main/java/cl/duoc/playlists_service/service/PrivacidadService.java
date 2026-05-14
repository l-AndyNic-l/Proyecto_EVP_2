package cl.duoc.playlists_service.service;

import cl.duoc.playlists_service.model.Privacidad;
import cl.duoc.playlists_service.repository.PrivacidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrivacidadService {

    @Autowired
    private PrivacidadRepository privacidadRepository;



    public List<Privacidad> findAll() {
        return privacidadRepository.findAll();
    }

    public Optional<Privacidad> findById(Long idPrivacidad) { return privacidadRepository.findById(idPrivacidad); }

    public Privacidad save(Privacidad privacidad) {
        return privacidadRepository.save(privacidad);
    }

    public Privacidad update(Long idPrivacidad, Privacidad privacidadNueva) {
        if (privacidadRepository.existsById(idPrivacidad)) {
            Privacidad privacidad = privacidadRepository.findById(idPrivacidad).orElse(null);

            privacidad.setNombre(privacidadNueva.getNombre());

            return privacidadRepository.save(privacidad);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idPrivacidad) {
        if (privacidadRepository.existsById(idPrivacidad)) {
            privacidadRepository.deleteById(idPrivacidad);
            return true;
        } else {
            return false;
        }
    }

}
