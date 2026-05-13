package cl.duoc.reproducciones_service.controller;

import cl.duoc.reproducciones_service.dto.ReproduccionDTO;
import cl.duoc.reproducciones_service.model.Dispositivo;
import cl.duoc.reproducciones_service.model.Reproduccion;
import cl.duoc.reproducciones_service.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/dispositivos" )
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping
    public List<Dispositivo> findAll() {
        return dispositivoService.findAll();
    }

    @GetMapping( "/{nombre}" )
    public Dispositivo findByNombre(@PathVariable String nombre) {
        return dispositivoService.findByNombre(nombre);
    }

    @PostMapping
    public Dispositivo save(@RequestBody Dispositivo d) {
        return dispositivoService.save(d);
    }

    @PutMapping( "/{id}" )
    public Dispositivo update(@PathVariable Long id, @RequestBody Dispositivo d) {
        return dispositivoService.update(id, d);
    }

    @DeleteMapping( "/{id}" )
    public Boolean delete(@PathVariable Long id) {
        return dispositivoService.delete(id);
    }


}
