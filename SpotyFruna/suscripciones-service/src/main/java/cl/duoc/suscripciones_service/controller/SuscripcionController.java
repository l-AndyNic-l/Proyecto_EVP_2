package cl.duoc.suscripciones_service.controller;

import cl.duoc.suscripciones_service.dto.SuscripcionDTO;
import cl.duoc.suscripciones_service.model.Suscripcion;
import cl.duoc.suscripciones_service.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @GetMapping
    public List<SuscripcionDTO> findAll() {
        return suscripcionService.findAll();
    }

    @GetMapping("/{id}")
    public SuscripcionDTO findById(@PathVariable Long id) {
        return suscripcionService.findById(id);
    }

    @PostMapping
    public Suscripcion save(@RequestBody Suscripcion s) {
        return suscripcionService.save(s);
    }

    @PutMapping("/{id}")
    public Suscripcion update(@PathVariable Long id, @RequestBody Suscripcion s ) {
        return suscripcionService.update(id, s);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable  Long id) {
        return suscripcionService.deleteById(id);
    }

}
