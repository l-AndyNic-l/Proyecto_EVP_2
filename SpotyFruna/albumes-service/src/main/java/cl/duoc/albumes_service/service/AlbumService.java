package cl.duoc.albumes_service.service;

import cl.duoc.albumes_service.model.Album;
import cl.duoc.albumes_service.repository.AlbumRepository;
import cl.duoc.albumes_service.dto.AlbumDTO;
import cl.duoc.albumes_service.dto.CancionDTO;
import cl.duoc.albumes_service.clients.CancionClient;
import cl.duoc.albumes_service.mapper.AlbumMapper;
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
        List<AlbumDTO> albumesDTO = new ArrayList<>();

        for(Album album : albumRepository.findAll()) {
            List<Long> idCanciones = new ArrayList<>();

            for (CancionDTO cancionDTO : cancionClient.findAllCancionesByAlbum(album.getId())) {
                idCanciones.add(cancionDTO.getIdCancion());
            }

            AlbumDTO albumDTO = mapper.toDTO(album, idCanciones);
            albumesDTO.add(albumDTO);
        }

        return albumesDTO;
    }

    public AlbumDTO findById(Long idAlbum) {
        List<Long> idCanciones = new ArrayList<>();

        for (CancionDTO cancionDTO : cancionClient.findAllCancionesByAlbum(idAlbum)) {
            idCanciones.add(cancionDTO.getIdCancion());
        }

        Album album =  albumRepository.findById(idAlbum).orElse(null);

        return mapper.toDTO(album, idCanciones);
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public Album update(Long idAlbum, Album albumNuevo) {
        if (albumRepository.existsById(idAlbum)) {
            Album album = albumRepository.findById(idAlbum).orElse(null);

            album.setNombre(albumNuevo.getNombre());
            album.setDescripcion(albumNuevo.getDescripcion());
            album.setFechaLanzamiento(albumNuevo.getFechaLanzamiento());
            album.setTipoAlbum(albumNuevo.getTipoAlbum());

            return albumRepository.save(album);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idAlbum) {
        if(albumRepository.existsById(idAlbum)) {
            albumRepository.deleteById(idAlbum);
            return true;
        } else {
            return false;
        }
    }

}
