package cl.duoc.suscripciones_service.dto;

import cl.duoc.suscripciones_service.model.Plan;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonPropertyOrder({"id", "fecha_inicio", "fecha_termino", "activado", "plan", "usuario"})
public class SuscripcionDTO {

    private Long idSuscripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private Boolean activado;
    private Long idPlan;
    private Long idUsuario;

}
