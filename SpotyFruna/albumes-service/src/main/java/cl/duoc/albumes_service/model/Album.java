package cl.duoc.albumes_service.model;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50)
    @Column(nullable = false, unique = true)
    private String nombre;

    @Size(min = 1, max = 300)
    @Column
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaLanzamiento = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_tipo_album", nullable = false)
    private TipoAlbum tipoAlbum;

}

