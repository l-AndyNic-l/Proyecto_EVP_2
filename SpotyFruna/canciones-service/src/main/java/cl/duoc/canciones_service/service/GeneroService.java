package cl.duoc.canciones_service.service;

import cl.duoc.canciones_service.model.Genero;
import cl.duoc.canciones_service.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;



    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Optional<Genero> findById(Long idGenero) { return generoRepository.findById(idGenero); }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero update(Long idGenero, Genero generoNuevo) {
        if (generoRepository.existsById(idGenero)) {
            Genero genero = generoRepository.findById(idGenero).orElse(null);

            genero.setNombre(generoNuevo.getNombre());

            return generoRepository.save(genero);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idGenero) {
        if (generoRepository.existsById(idGenero)) {
            generoRepository.deleteById(idGenero);
            return true;
        } else {
            return false;
        }
    }

}
