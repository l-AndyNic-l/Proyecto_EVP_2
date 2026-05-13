package cl.duoc.reproducciones_service.controller;

import cl.duoc.reproducciones_service.dto.ReproduccionDTO;
import cl.duoc.reproducciones_service.model.Reproduccion;
import cl.duoc.reproducciones_service.service.ReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/reproducciones" )
public class ReproduccionController {

    @Autowired
    private ReproduccionService reproduccionService;

    @GetMapping
    public List<ReproduccionDTO> findAll() {
        return reproduccionService.findAll();
    }

    @GetMapping( "/{id}" )
    public ReproduccionDTO findById(@PathVariable Long id) {
        return reproduccionService.findById(id);
    }

    @PostMapping
    public Reproduccion save(@RequestBody Reproduccion r) {
        return reproduccionService.save(r);
    }

    @PutMapping( "/{id}" )
    public Reproduccion update(@PathVariable Long id, @RequestBody Reproduccion r) {
        return reproduccionService.update(id, r);
    }

    @DeleteMapping( "/{id}" )
    public Boolean delete(@PathVariable Long id) {
        return reproduccionService.delete(id);
    }

}
