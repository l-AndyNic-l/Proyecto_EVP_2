package cl.duoc.canciones_service.controller;

import cl.duoc.canciones_service.model.Cancion;
import cl.duoc.canciones_service.dto.CancionDTO;
import cl.duoc.canciones_service.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;



    @GetMapping
    public List<CancionDTO> findAll() {
        return cancionService.findAll();
    }

    @GetMapping( "/{idCancion}" )
    public CancionDTO findById(@PathVariable Long idCancion) {
        return cancionService.findById(idCancion);
    }

    @GetMapping("/album/{idAlbum}")
    public List<CancionDTO> findAllCancionesByAlbum(@PathVariable Long idAlbum) {
        return cancionService.findAllCancionesByAlbum(idAlbum);
    }

    @PostMapping
    public Cancion save(@RequestBody Cancion cancion) {
        return cancionService.save(cancion);
    }

    @PutMapping( "/{idCancion}" )
    public Cancion update(@PathVariable Long idCancion, @RequestBody Cancion cancion) {
        return cancionService.update(idCancion, cancion);
    }

    @DeleteMapping( "/{idCancion}" )
    public Boolean delete(@PathVariable  Long idCancion) {
        return cancionService.deleteById(idCancion);
    }

}
