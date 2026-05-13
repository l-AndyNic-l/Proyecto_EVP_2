package cl.duoc.albumes_service.mapper;

import cl.duoc.albumes_service.dto.AlbumDTO;
import cl.duoc.albumes_service.model.Album;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumMapper {

    public AlbumDTO toDTO(Album a, List<Long> idCanciones) {

        if(a == null) {
            return null;
        }

        AlbumDTO dto = new AlbumDTO();

        dto.setNombre(a.getNombre());
        dto.setDescripcion(a.getDescripcion());
        dto.setFechaLanzamiento(a.getFechaLanzamiento());
        dto.setIdTipoAlbum(a.getTipoAlbum().getId());
        dto.setIdCanciones(idCanciones);

        return dto;
    }

}
