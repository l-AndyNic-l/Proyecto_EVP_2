package cl.duoc.playlists_service.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@JsonPropertyOrder({"id_playlist", "nombre", "descripcion", "fecha_creacion", "privacidad", "canciones", "generos"})
public class PlaylistDTO {

    private Long idPlaylist;
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String privacidad;
    private List<CancionDTO> cancionDTOS;
    private String usuario;

}
