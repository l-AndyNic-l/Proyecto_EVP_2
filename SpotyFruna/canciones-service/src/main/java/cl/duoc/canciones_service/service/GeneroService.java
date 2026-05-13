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

    public Optional<Genero> findById(Long id) { return generoRepository.findById(id); }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero update(Long id, Genero g) {
        if (generoRepository.existsById(id)) {
            Genero genero = generoRepository.findById(id).orElse(null);
            genero.setNombre(g.getNombre());

            return generoRepository.save(genero);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if (generoRepository.existsById(id)) {

            generoRepository.deleteById(id);
            return true;

        } else {
            return false;
        }
    }

}
