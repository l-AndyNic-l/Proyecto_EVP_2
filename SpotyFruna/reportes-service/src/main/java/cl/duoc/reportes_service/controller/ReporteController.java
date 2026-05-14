package cl.duoc.reportes_service.controller;

import cl.duoc.reportes_service.model.Reporte;
import cl.duoc.reportes_service.dto.ReporteDTO;
import cl.duoc.reportes_service.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;



    @GetMapping
    public List<ReporteDTO> findAll() {
        return reporteService.findAll();
    }

    @GetMapping("/{idReporte}")
    public ReporteDTO findOne(@PathVariable Long idReporte) {
        return reporteService.findById(idReporte);
    }

    @PostMapping
    public Reporte save(@RequestBody Reporte reporte) {
        return reporteService.save(reporte);
    }

    @PutMapping("/{idReporte}")
    public Reporte update(@PathVariable Long idReporte, @RequestBody Reporte reporte) {
        return reporteService.update(idReporte, reporte);
    }

    @DeleteMapping("/{idReporte}")
    public Boolean deleteById(@PathVariable Long idReporte){
        return reporteService.delete(idReporte);
    }


}
