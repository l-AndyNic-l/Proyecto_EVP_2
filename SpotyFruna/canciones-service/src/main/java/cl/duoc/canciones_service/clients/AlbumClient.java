package cl.duoc.canciones_service.clients;

import cl.duoc.canciones_service.dto.AlbumDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "albumes-service", url = "http://localhost:8080/api/v1/albumes")
public interface AlbumClient {

    @GetMapping( "/{id}" )
    AlbumDTO findById(@PathVariable Long id);

}
