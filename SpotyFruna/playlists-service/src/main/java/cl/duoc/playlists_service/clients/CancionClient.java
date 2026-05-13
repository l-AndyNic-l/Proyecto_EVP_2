package cl.duoc.playlists_service.clients;

import cl.duoc.playlists_service.dto.CancionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "canciones-service", url = "http://localhost:8080/api/v1/canciones")
public interface CancionClient {

    @GetMapping("/list/{idPlaylist}")
    CancionDTO findAllPlaylistCanciones(@PathVariable Long idPlaylist);

    CancionDTO findById(Long idCancion);
}
