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

    public Optional<TipoAlbum> findById(Long idTipoAlbum) {
        return tipoAlbumRepository.findById(idTipoAlbum);
    }

    public TipoAlbum save(TipoAlbum tipoAlbum) {
        return tipoAlbumRepository.save(tipoAlbum);
    }

    public TipoAlbum update(Long idTipoAlbum, TipoAlbum tipoAlbumNuevo) {
        if (tipoAlbumRepository.existsById(idTipoAlbum)) {
            TipoAlbum tipoAlbum = tipoAlbumRepository.findById(idTipoAlbum).orElse(null);

            tipoAlbum.setNombre(tipoAlbumNuevo.getNombre());

            return tipoAlbumRepository.save(tipoAlbum);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idTipoAlbum) {
        if (tipoAlbumRepository.existsById(idTipoAlbum)) {
            tipoAlbumRepository.deleteById(idTipoAlbum);
            return true;
        } else {
            return false;
        }
    }

}
