package cl.duoc.reproducciones_service.clients;

import cl.duoc.reproducciones_service.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "usuarios-service", url = "http://localhost:8080/api/v1/usuarios-service" )
public interface UsuarioFeing {

    @GetMapping( "/{id}" )
    UsuarioDTO findById( @PathVariable Long id );

}
