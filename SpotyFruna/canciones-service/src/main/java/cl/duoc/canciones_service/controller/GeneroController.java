package cl.duoc.canciones_service.controller;

import cl.duoc.canciones_service.model.Genero;
import cl.duoc.canciones_service.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> findAll() {
        return generoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Genero> findById(@PathVariable Long id) {
        return generoService.findById(id);
    }

    @PostMapping
    public Genero save(@RequestBody Genero g) {
        return generoService.save(g);
    }

    @PutMapping("/{id}")
    public Genero update(@PathVariable Long id, @RequestBody Genero g) {
        return generoService.update(id, g);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable  Long id) {
        return generoService.deleteById(id);
    }

}
