package cl.duoc.reportes_service.clients;

import cl.duoc.reportes_service.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-service", url = "http://localhost:8080/api/v1/usuarios")
public interface UsuarioClient {

    @GetMapping("/{idUsuario}")
    UsuarioDTO findById(@PathVariable("idUsuario") Long idUsuario);

}
