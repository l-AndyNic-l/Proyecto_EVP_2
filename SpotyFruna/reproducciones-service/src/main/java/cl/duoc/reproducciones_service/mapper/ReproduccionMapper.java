package cl.duoc.reproducciones_service.mapper;

import cl.duoc.reproducciones_service.dto.CancionDTO;
import cl.duoc.reproducciones_service.dto.ReproduccionDTO;
import cl.duoc.reproducciones_service.dto.UsuarioDTO;
import cl.duoc.reproducciones_service.model.Reproduccion;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ReproduccionMapper {

    public ReproduccionDTO toDTO( Reproduccion r, CancionDTO c, UsuarioDTO u ) {

        if ( r == null ) {
            return null;

        }

        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
        ReproduccionDTO dto = new ReproduccionDTO();
        int minutos = r.getSegundosEscuchados() / 60;
        int segundos = r.getSegundosEscuchados() % 60;

        dto.setId( r.getId() );
        dto.setFechaReproduccion( sdf.format( r.getFechaReproduccion() ) );

        if ( minutos < 10 ) {
            dto.setTiempoEscuchado( "0" + minutos + ":" + segundos );

        } else {
            dto.setTiempoEscuchado( minutos + ":" + segundos );
        }

        if ( r.getDispositivo() != null ) {
            dto.setDispositivo( r.getDispositivo().getNombre() );

        } else {
            dto.setDispositivo( "Sin Dispositivo" );
        }

        dto.setUsuario( u );
        dto.setCancion( c );
        return dto;

    }

}
