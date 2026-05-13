package cl.duoc.canciones_service.controller;

import cl.duoc.canciones_service.dto.CancionDTO;
import cl.duoc.canciones_service.model.Cancion;
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

    @GetMapping( "/{id}" )
    public CancionDTO findById(@PathVariable Long id) {
        return cancionService.findById(id);
    }

    @GetMapping("/list/{idList}")
    public List<CancionDTO> findAllAlbumCanciones(@PathVariable Long idAlbum) {
        return cancionService.findAllAlbumCanciones(idAlbum);
    }

    @PostMapping
    public Cancion save(@RequestBody Cancion c) {
        return cancionService.save(c);
    }

    @PutMapping( "/{id}" )
    public Cancion update(@PathVariable Long id, @RequestBody Cancion c) {
        return cancionService.update(id, c);
    }

    @DeleteMapping( "/{id}" )
    public Boolean delete(@PathVariable  Long id) {
        return cancionService.deleteById(id);
    }

}
