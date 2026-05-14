package cl.duoc.reportes_service.service;

import cl.duoc.reportes_service.model.Reporte;
import cl.duoc.reportes_service.repository.ReporteRepository;
import cl.duoc.reportes_service.dto.ReporteDTO;
import cl.duoc.reportes_service.dto.UsuarioDTO;
import cl.duoc.reportes_service.clients.UsuarioClient;
import cl.duoc.reportes_service.mapper.ReporteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private ReporteMapper mapper;



    public List<ReporteDTO> findAll() {
        List<ReporteDTO> reportesDTO = new ArrayList<>();

        for (Reporte reporte : reporteRepository.findAll()) {
            UsuarioDTO administradorDTO = usuarioClient.findById(reporte.getAdministrador());
            UsuarioDTO usuarioDTO = usuarioClient.findById(reporte.getUsuario());
            ReporteDTO reporteDTO = mapper.toDTO(reporte, administradorDTO, usuarioDTO);

            reportesDTO.add(reporteDTO);
        }

        return reportesDTO;
    }

    public ReporteDTO findById(Long idReporte) {
        Reporte reporte = reporteRepository.findById(idReporte).orElse(null);

        UsuarioDTO administradorDTO = usuarioClient.findById(reporte.getAdministrador());
        UsuarioDTO usuarioDTO = usuarioClient.findById(reporte.getUsuario());

        return mapper.toDTO(reporte, administradorDTO, usuarioDTO);
    }

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte update(Long idReporte, Reporte reporteNuevo) {
        if( reporteRepository.existsById(idReporte)) {
            Reporte reporte = reporteRepository.findById(idReporte).orElse(null);

            reporte.setFechaResuelto(reporteNuevo.getFechaResuelto());
            reporte.setEstado(reporteNuevo.getEstado());

            return reporteRepository.save( reporte );
        } else {
            return null;
        }
    }

    public Boolean delete(Long idReporte) {
        if( reporteRepository.existsById(idReporte)) {
            reporteRepository.deleteById(idReporte);
            return true;
        } else {
            return false;
        }
    }

}
