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
    public SuscripcionDTO findById(@PathVariable Long idSuscripcion) {
        return suscripcionService.findById(idSuscripcion);
    }

    @PostMapping
    public Suscripcion save(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.save(suscripcion);
    }

    @PutMapping("/{id}")
    public Suscripcion update(@PathVariable Long idSuscripcion, @RequestBody Suscripcion suscripcion ) {
        return suscripcionService.update(idSuscripcion, suscripcion);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long idSuscripcion) {
        return suscripcionService.deleteById(idSuscripcion);
    }

}
