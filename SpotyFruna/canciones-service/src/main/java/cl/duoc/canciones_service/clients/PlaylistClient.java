package cl.duoc.canciones_service.clients;

import cl.duoc.canciones_service.dto.PlaylistDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "playlists-service", url = "http://localhost:8080/api/v1/playlists")
public interface PlaylistClient {

    @GetMapping
    List<PlaylistDTO> findAll();

}
