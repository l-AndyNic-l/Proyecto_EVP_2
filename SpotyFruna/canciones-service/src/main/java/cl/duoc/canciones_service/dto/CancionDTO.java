package cl.duoc.canciones_service.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@JsonPropertyOrder({"id", "autor", "titulo", "duracion", "fecha_lanzamiento", "genero", "album", "playlist"})
public class CancionDTO {

    private Long idCancion;
    private String autor;
    private String titulo;
    private Long duracion;
    private LocalDate fechaLanzamiento;
    private Long idGenero;
    private Long idAlbum;
    private List<Long> idPlaylists;

}
