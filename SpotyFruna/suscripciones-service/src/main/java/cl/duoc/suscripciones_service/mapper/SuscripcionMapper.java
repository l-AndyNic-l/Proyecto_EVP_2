package cl.duoc.suscripciones_service.mapper;

import cl.duoc.suscripciones_service.dto.SuscripcionDTO;
import cl.duoc.suscripciones_service.model.Suscripcion;
import org.springframework.stereotype.Component;

@Component
public class SuscripcionMapper {

    public SuscripcionDTO toDTO(Suscripcion s) {

        if(s == null) {
            return null;
        }

        SuscripcionDTO dto = new SuscripcionDTO();

        dto.setFechaInicio(s.getFechaInicio());
        dto.setFechaTermino(s.getFechaTermino());
        dto.setActivado(s.getActivado());
        dto.setIdPlan(s.getPlan().getId());
        dto.setIdUsuario(s.getIdUsuario());

        return dto;
    }

}
