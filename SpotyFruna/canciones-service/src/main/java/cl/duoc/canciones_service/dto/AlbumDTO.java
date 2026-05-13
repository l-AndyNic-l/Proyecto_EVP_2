package cl.duoc.canciones_service.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonPropertyOrder({"id", "nombre", "descripcion", "fecha_lanzamiento", "tipo_album", "canciones", "generos"})
public class AlbumDTO {

    private Long idAlbum;
    private String nombre;
    private String descripcion;
    private LocalDate fechaLanzamiento;
    private Long idTipoAlbum;
    private List<Long> idCanciones;

}


