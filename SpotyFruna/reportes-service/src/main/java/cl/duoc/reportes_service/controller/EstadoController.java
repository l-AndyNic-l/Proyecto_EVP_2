package cl.duoc.reportes_service.controller;

import cl.duoc.reportes_service.model.Estado;
import cl.duoc.reportes_service.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/api/v1/estados" )
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> findAll() {
        return estadoService.findAll();
    }

    @GetMapping( "/{tipo}" )
    public Estado findOne(@PathVariable String tipo) {
        return estadoService.findByNombre(tipo);
    }

    @PostMapping
    public Estado save(@RequestBody Estado estado) {
        return estadoService.save(estado);
    }

    @PutMapping( "/{id}" )
    public Estado update(@PathVariable Long id, @RequestBody Estado estado) {
        return estadoService.update(id, estado);
    }

    @DeleteMapping( "/{id}" )
    public Boolean deleteById(@PathVariable Long id){
        return estadoService.deleteById(id);
    }

}
