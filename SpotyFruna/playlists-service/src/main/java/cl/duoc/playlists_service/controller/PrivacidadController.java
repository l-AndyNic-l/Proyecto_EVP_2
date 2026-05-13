package cl.duoc.playlists_service.controller;

import cl.duoc.playlists_service.model.Privacidad;
import cl.duoc.playlists_service.service.PrivacidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/api/v1/privacidades" )
public class PrivacidadController {

    @Autowired
    private PrivacidadService privacidadService;

    @GetMapping
    public List<Privacidad> findAll() {
        return privacidadService.findAll();
    }

    @GetMapping( "/{id}" )
    public Optional<Privacidad> findById(@PathVariable Long id) {
        return privacidadService.findById(id);
    }

    @PostMapping
    public Privacidad save(@RequestBody Privacidad p) {
        return privacidadService.save(p);
    }

    @PutMapping( "/{id}" )
    public Privacidad update(@PathVariable Long id, @RequestBody Privacidad p) {
        return privacidadService.update(id, p);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return privacidadService.deleteById(id);
    }

}
