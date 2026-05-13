package cl.duoc.canciones_service.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonPropertyOrder({"id_playlist", "nombre_playlist", "descripcion", "fecha_creacion", "privacidad", "canciones", "generos"})
public class PlaylistDTO {

    private Long idPlaylist;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private Long idPrivacidad;
    private List<Long> idCanciones;

}
