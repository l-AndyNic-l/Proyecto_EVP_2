package cl.duoc.reportes_service.service;

import cl.duoc.reportes_service.clients.UsuariosFeing;
import cl.duoc.reportes_service.dto.ReporteDTO;
import cl.duoc.reportes_service.dto.UsuarioDTO;
import cl.duoc.reportes_service.mapper.ReporteMapper;
import cl.duoc.reportes_service.model.Reporte;
import cl.duoc.reportes_service.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private UsuariosFeing usuarios;

    @Autowired
    private ReporteMapper mapper;

    public List<ReporteDTO> findAll() {
        List<ReporteDTO> reportes = new ArrayList<>();

        for( Reporte r : reporteRepository.findAll() ) {
            UsuarioDTO administradorDTO = usuarios.findById( r.getAdministrador() );
            UsuarioDTO usuarioDTO = usuarios.findById( r.getUsuario() );
            ReporteDTO reporteDTO = mapper.toDTO( r, administradorDTO, usuarioDTO );

            reportes.add( reporteDTO );
        }

        return reportes;
    }

    public ReporteDTO findById( Long id ) {
        Reporte reporte = reporteRepository.findById( id ).orElse(null);
        UsuarioDTO administradorDTO = usuarios.findById( reporte.getAdministrador() );
        UsuarioDTO usuarioDTO = usuarios.findById( reporte.getUsuario() );

        return mapper.toDTO( reporte, administradorDTO, usuarioDTO );
    }

    public Reporte save( Reporte r ) {
        return reporteRepository.save(r);
    }

    public Reporte update( Long id,  Reporte r ) {
        if( reporteRepository.existsById( id ) ) {

            Reporte reporte = reporteRepository.findById( id ).orElse(null);
            reporte.setFechaResuelto( r.getFechaResuelto() );
            reporte.setEstado( r.getEstado() );

            return reporteRepository.save( reporte );

        } else {
            return null;
        }
    }

    public Boolean delete( Long id ) {
        if( reporteRepository.existsById( id ) ) {

            reporteRepository.deleteById( id );
            return true;

        } else {
            return false;
        }
    }

}
