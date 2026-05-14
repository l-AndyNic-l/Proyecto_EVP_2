package cl.duoc.playlists_service.controller;

import cl.duoc.playlists_service.model.GuardarCancion;
import cl.duoc.playlists_service.service.GuardarCancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/playlists-canciones")
public class GuardarCancionController {


    @Autowired
    private GuardarCancionService guardarCancionService;

    @GetMapping
    public List<GuardarCancion> findAll() {
        return guardarCancionService.findAll();
    }

    @GetMapping( "/{idGuardarCancion}" )
    public Optional<GuardarCancion> findById(@PathVariable Long idGuardarCancion) {
        return guardarCancionService.findById(idGuardarCancion);
    }

    @PostMapping
    public GuardarCancion save(@RequestBody GuardarCancion guardarCancion) {
        return guardarCancionService.save(guardarCancion);
    }

    @PutMapping( "/{idGuardarCancion}" )
    public GuardarCancion update(@PathVariable Long idGuardarCancion, @RequestBody GuardarCancion guardarCancion) {
        return guardarCancionService.update(idGuardarCancion, guardarCancion);
    }

    @DeleteMapping("/{idGuardarCancion}")
    public Boolean delete(@PathVariable Long idGuardarCancion) {
        return guardarCancionService.deleteById(idGuardarCancion);
    }
}
