package cl.duoc.albumes_service.service;

import cl.duoc.albumes_service.model.TipoAlbum;
import cl.duoc.albumes_service.repository.TipoAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAlbumService {

    @Autowired
    private TipoAlbumRepository tipoAlbumRepository;

    public List<TipoAlbum> findAll() {
        return tipoAlbumRepository.findAll();
    }

    public Optional<TipoAlbum> findById(Long id) { return tipoAlbumRepository.findById(id); }

    public TipoAlbum save(TipoAlbum tp) {
        return tipoAlbumRepository.save(tp);
    }

    public TipoAlbum update(Long id, TipoAlbum tp) {
        if (tipoAlbumRepository.existsById(id)) {
            TipoAlbum tipoAlbum = tipoAlbumRepository.findById(id).orElse(null);
            tipoAlbum.setNombre(tp.getNombre());

            return tipoAlbumRepository.save(tipoAlbum);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if (tipoAlbumRepository.existsById(id)) {

            tipoAlbumRepository.deleteById(id);
            return true;

        } else {
            return false;
        }
    }

}
