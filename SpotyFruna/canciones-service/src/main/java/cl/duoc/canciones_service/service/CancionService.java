package cl.duoc.canciones_service.service;

import cl.duoc.canciones_service.model.Cancion;
import cl.duoc.canciones_service.repository.CancionRepository;
import cl.duoc.canciones_service.dto.CancionDTO;
import cl.duoc.canciones_service.clients.AlbumClient;
import cl.duoc.canciones_service.mapper.CancionMapper;
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
    private CancionMapper mapper;



    public List<CancionDTO> findAll() {
        List<CancionDTO> cancionesDTO = new ArrayList<>();

        for(Cancion cancion : cancionRepository.findAll()) {
            CancionDTO cancionDTO = mapper.toDTO(cancion);
            cancionesDTO.add(cancionDTO);
        }

        return cancionesDTO;
    }

    public CancionDTO findById(Long idCancion) {
        Cancion cancion = cancionRepository.findById(idCancion).orElse(null);
        return mapper.toDTO(cancion);
    }

    public List<CancionDTO> findAllCancionesByAlbum(Long idAlbum) {
        List<CancionDTO> albumCanciones = new ArrayList<>();

        for(Cancion cancion : cancionRepository.findAll()) {
            CancionDTO cancionDTO = mapper.toDTO(cancion);

            if (cancionDTO.getIdAlbum() == idAlbum) {
                albumCanciones.add(cancionDTO);
            }
        }

        return albumCanciones;
    }

    public Cancion save(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public Cancion update(Long idCancion, Cancion cancionNueva) {
        if (cancionRepository.existsById(idCancion)) {

            albumClient.findById(cancionNueva.getIdAlbum());

            Cancion cancion = cancionRepository.findById(idCancion).orElse(null);

            cancion.setAutor(cancionNueva.getAutor());
            cancion.setTitulo(cancionNueva.getTitulo());
            cancion.setDuracion(cancionNueva.getDuracion());
            cancion.setFechaLanzamiento(cancionNueva.getFechaLanzamiento());
            cancion.setGenero(cancionNueva.getGenero());
            cancion.setIdAlbum(cancionNueva.getIdAlbum());

            return cancionRepository.save(cancion);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idCancion) {
        if(cancionRepository.existsById(idCancion)) {
            cancionRepository.deleteById(idCancion);
            return true;
        } else {
            return false;
        }
    }

}
