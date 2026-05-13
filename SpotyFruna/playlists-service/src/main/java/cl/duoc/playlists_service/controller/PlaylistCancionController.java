package cl.duoc.playlists_service.controller;

import cl.duoc.playlists_service.model.GuardarCancion;
import cl.duoc.playlists_service.service.PlaylistCancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/playlists-canciones")
public class PlaylistCancionController {


    @Autowired
    private PlaylistCancionService playlistCancionService;

    @GetMapping
    public List<GuardarCancion> findAll() {
        return playlistCancionService.findAll();
    }

    @GetMapping( "/{id}" )
    public Optional<GuardarCancion> findById(@PathVariable Long id) {
        return playlistCancionService.findById(id);
    }

    @PostMapping
    public GuardarCancion save(@RequestBody GuardarCancion pC) {
        return playlistCancionService.save(pC);
    }

    @PutMapping( "/{id}" )
    public GuardarCancion update(@PathVariable Long id, @RequestBody GuardarCancion pC) {
        return playlistCancionService.update(id, pC);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return playlistCancionService.deleteById(id);
    }
}
