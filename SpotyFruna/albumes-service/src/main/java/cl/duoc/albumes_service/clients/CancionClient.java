package cl.duoc.albumes_service.clients;

import cl.duoc.albumes_service.dto.CancionDTO;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "canciones-service", url = "http://localhost:8080/api/v1/canciones")
public interface CancionClient {

    @GetMapping("/list/{idList}")
    List<CancionDTO> findAllCancionesByAlbum(@PathVariable Long idAlbum);

}
