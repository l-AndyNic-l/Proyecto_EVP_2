package cl.duoc.canciones_service.service;

import cl.duoc.canciones_service.clients.AlbumClient;
import cl.duoc.canciones_service.clients.PlaylistClient;
import cl.duoc.canciones_service.model.Cancion;
import cl.duoc.canciones_service.mapper.CancionMapper;
import cl.duoc.canciones_service.dto.CancionDTO;
import cl.duoc.canciones_service.repository.CancionRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    @Autowired
    private AlbumClient albumClient;

    @Autowired
    private PlaylistClient playlistClient;

    @Autowired
    private CancionMapper mapper;

    public List<CancionDTO> findAll() {
        List<CancionDTO> listado = new ArrayList<>();

        for(Cancion c : cancionRepository.findAll()) {
            CancionDTO c_dto = mapper.toDTO(c);
            listado.add(c_dto);
        }

        return listado;
    }

    public CancionDTO findById(Long id) {
        Cancion s =  cancionRepository.findById(id).orElse(null);
        return mapper.toDTO(s);
    }

    public List<CancionDTO> findAllAlbumCanciones(Long idAlbum) {
        List<CancionDTO> albumCanciones = new ArrayList<>();
        for(Cancion c : cancionRepository.findAll()) {
            CancionDTO c_dto = mapper.toDTO(c);
            if (c_dto.getIdAlbum() == idAlbum) {
                albumCanciones.add(c_dto);
            }
        }

        return albumCanciones;
    }

    public List<CancionDTO> findAllPlaylistCanciones(Long idPlaylist) {
        List<CancionDTO> playlistCanciones = new ArrayList<>();
        for(Cancion c : cancionRepository.findAll()) {
            CancionDTO c_dto = mapper.toDTO(c);
            for (Long id : c_dto.getIdPlaylists()) {
                if (id == idPlaylist) {
                    playlistCanciones.add(c_dto);
                }
            }
        }
        return playlistCanciones;
    }

    public Cancion save(Cancion c) {
        return cancionRepository.save(c);
    }

    public Cancion update(Long id, Cancion c) {

        if ( cancionRepository.existsById(id) ) {

            albumClient.findById(c.getIdAlbum());

            Cancion cancion = cancionRepository.findById(id).orElse(null);

            cancion.setAutor(c.getAutor());
            cancion.setTitulo(c.getTitulo());
            cancion.setDuracion(c.getDuracion());
            cancion.setFechaLanzamiento(c.getFechaLanzamiento());
            cancion.setGenero(c.getGenero());
            cancion.setIdAlbum(c.getIdAlbum());

            return cancionRepository.save(cancion);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if(cancionRepository.existsById(id)) {
            cancionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
