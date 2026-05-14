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

    @GetMapping( "/{idPrivacidad}" )
    public Optional<Privacidad> findById(@PathVariable Long idPrivacidad) {
        return privacidadService.findById(idPrivacidad);
    }

    @PostMapping
    public Privacidad save(@RequestBody Privacidad privacidad) {
        return privacidadService.save(privacidad);
    }

    @PutMapping( "/{idPrivacidad}" )
    public Privacidad update(@PathVariable Long idPrivacidad, @RequestBody Privacidad privacidad) {
        return privacidadService.update(idPrivacidad, privacidad);
    }

    @DeleteMapping("/{idPrivacidad}")
    public Boolean delete(@PathVariable Long idPrivacidad) {
        return privacidadService.deleteById(idPrivacidad);
    }

}
