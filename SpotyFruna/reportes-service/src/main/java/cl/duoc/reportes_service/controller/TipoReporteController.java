package cl.duoc.reportes_service.controller;

import cl.duoc.reportes_service.model.TipoReporte;
import cl.duoc.reportes_service.service.TipoReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tipos-reportes")
public class TipoReporteController {

    @Autowired
    private TipoReporteService tipoReporteService;



    @GetMapping
    public List<TipoReporte> findAll() {
        return tipoReporteService.findAll();
    }

    @GetMapping("/{tipoReporte}")
    public TipoReporte findOne(@PathVariable String tipoReporte) {
        return tipoReporteService.findByNombre(tipoReporte);
    }

    @PostMapping
    public TipoReporte save(@RequestBody TipoReporte tipoReporte) {
        return tipoReporteService.save(tipoReporte);
    }

    @PutMapping( "/{idTipoReporte}" )
    public TipoReporte update(@PathVariable Long idTipoReporte, @RequestBody TipoReporte tipoReporte) {
        return tipoReporteService.update(idTipoReporte, tipoReporte);
    }

    @DeleteMapping( "/{idTipoReporte}" )
    public Boolean deleteById(@PathVariable Long idTipoReporte){
        return tipoReporteService.deleteById(idTipoReporte);
    }

}
