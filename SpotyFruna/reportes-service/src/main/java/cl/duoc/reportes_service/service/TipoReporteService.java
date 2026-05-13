package cl.duoc.reportes_service.service;

import cl.duoc.reportes_service.model.TipoReporte;
import cl.duoc.reportes_service.repository.TipoReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoReporteService {

    @Autowired
    private TipoReporteRepository tipoReporteRepository;

    public List<TipoReporte> findAll() {
        return tipoReporteRepository.findAll();
    }

    public TipoReporte findByNombre( String nombre ) {
        return tipoReporteRepository.findByNombre( nombre );
    }

    public TipoReporte save( TipoReporte tipoReporte ) {
        return tipoReporteRepository.save( tipoReporte );
    }

    public TipoReporte update( Long id, TipoReporte t ) {
        if ( tipoReporteRepository.existsById( id ) ) {
            TipoReporte tipoReporte = tipoReporteRepository.findById( id ).orElse(null);
            tipoReporte.setNombre( t.getNombre() );

            return tipoReporteRepository.save( tipoReporte );

        } else  {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if ( tipoReporteRepository.existsById(id) ) {

            tipoReporteRepository.deleteById(id);
            return true;

        } else {
            return false;
        }
    }

}
