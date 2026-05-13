package cl.duoc.reportes_service.controller;

import cl.duoc.reportes_service.model.TipoReporte;
import cl.duoc.reportes_service.service.TipoReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/api/v1/tipos-reportes" )
public class TipoReporteController {

    @Autowired
    private TipoReporteService tipoReporteService;

    @GetMapping
    public List<TipoReporte> findAll() {
        return tipoReporteService.findAll();
    }

    @GetMapping( "/{tipo}" )
    public TipoReporte findOne(@PathVariable String tipo) {
        return tipoReporteService.findByNombre(tipo);
    }

    @PostMapping
    public TipoReporte save(@RequestBody TipoReporte tipoReporte) {
        return tipoReporteService.save(tipoReporte);
    }

    @PutMapping( "/{id}" )
    public TipoReporte update(@PathVariable Long id, @RequestBody TipoReporte tipoReporte) {
        return tipoReporteService.update(id, tipoReporte);
    }

    @DeleteMapping( "/{id}" )
    public Boolean deleteById(@PathVariable Long id){
        return tipoReporteService.deleteById(id);
    }

}
