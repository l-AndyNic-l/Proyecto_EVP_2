package cl.duoc.albumes_service.service;

import cl.duoc.albumes_service.clients.CancionClient;
import cl.duoc.albumes_service.dto.CancionDTO;
import cl.duoc.albumes_service.model.Album;
import cl.duoc.albumes_service.mapper.AlbumMapper;
import cl.duoc.albumes_service.dto.AlbumDTO;
import cl.duoc.albumes_service.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private CancionClient cancionClient;

    @Autowired
    private AlbumMapper mapper;

    public List<AlbumDTO> findAll() {
        List<AlbumDTO> listado = new ArrayList<>();

        for(Album a : albumRepository.findAll()) {
            List<Long> idCanciones = new ArrayList<>();
            for (CancionDTO c : cancionClient.findAllListCanciones(a.getId())) {
                idCanciones.add(c.getIdCancion());
            }
            AlbumDTO a_dto = mapper.toDTO(a, idCanciones);
            listado.add(a_dto);
        }

        return listado;
    }

    public AlbumDTO findById(Long id) {
        List<Long> idCanciones = new ArrayList<>();
        for (CancionDTO c : cancionClient.findAllListCanciones(id)) {
            idCanciones.add(c.getIdCancion());
        }
        Album a =  albumRepository.findById(id).orElse(null);
        return mapper.toDTO(a, idCanciones);
    }

    public Album save(Album a) {
        return albumRepository.save(a);
    }

    public Album update(Long id, Album a) {
        if ( albumRepository.existsById(id) ) {

            Album album = albumRepository.findById(id).orElse(null);
            album.setNombre(a.getNombre());
            album.setDescripcion(a.getDescripcion());
            album.setFechaLanzamiento(a.getFechaLanzamiento());
            album.setTipoAlbum(a.getTipoAlbum());

            return albumRepository.save(album);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if(albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
