package cl.duoc.playlists_service.mapper;


import cl.duoc.playlists_service.dto.CancionDTO;
import cl.duoc.playlists_service.dto.PlaylistDTO;
import cl.duoc.playlists_service.dto.UsuarioDTO;
import cl.duoc.playlists_service.model.Playlist;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaylistMapper {

    public PlaylistDTO toDTO(Playlist p, List<CancionDTO> cancionDTOS, UsuarioDTO u) {
        if(p == null) {
            return null;
        }

        PlaylistDTO dto = new PlaylistDTO();

        dto.setIdPlaylist( p.getId() );
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setFechaCreacion(p.getFechaCreacion());
        dto.setPrivacidad(p.getPrivacidad().getNombre());
        dto.setCancionDTOS(cancionDTOS);
        dto.setUsuario(u.getNickname());

        return dto;
    }

}
