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

    @GetMapping("/{idGenero}")
    public Optional<Genero> findById(@PathVariable Long idGenero) {
        return generoService.findById(idGenero);
    }

    @PostMapping
    public Genero save(@RequestBody Genero genero) {
        return generoService.save(genero);
    }

    @PutMapping("/{idGenero}")
    public Genero update(@PathVariable Long idGenero, @RequestBody Genero genero) {
        return generoService.update(idGenero, genero);
    }

    @DeleteMapping("/{idGenero}")
    public Boolean delete(@PathVariable  Long idGenero) {
        return generoService.deleteById(idGenero);
    }

}
