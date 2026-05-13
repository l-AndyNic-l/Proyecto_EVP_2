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

    public Optional<Privacidad> findById(Long id) { return privacidadRepository.findById(id); }

    public Privacidad save(Privacidad p) {
        return privacidadRepository.save(p);
    }

    public Privacidad update(Long id, Privacidad p) {
        if (privacidadRepository.existsById(id)) {
            Privacidad privacidad = privacidadRepository.findById(id).orElse(null);
            privacidad.setNombre(p.getNombre());

            return privacidadRepository.save(privacidad);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if (privacidadRepository.existsById(id)) {

            privacidadRepository.deleteById(id);
            return true;

        } else {
            return false;
        }
    }

}
