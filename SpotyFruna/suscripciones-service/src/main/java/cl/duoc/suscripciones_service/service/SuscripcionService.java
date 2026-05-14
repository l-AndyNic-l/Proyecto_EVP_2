package cl.duoc.suscripciones_service.service;

import cl.duoc.suscripciones_service.model.Suscripcion;
import cl.duoc.suscripciones_service.repository.SuscripcionRepository;
import cl.duoc.suscripciones_service.dto.SuscripcionDTO;
import cl.duoc.suscripciones_service.clients.UsuarioClient;
import cl.duoc.suscripciones_service.mapper.SuscripcionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private SuscripcionMapper mapper;



    public List<SuscripcionDTO> findAll() {
        List<SuscripcionDTO> suscripcionesDTO = new ArrayList<>();

        for(Suscripcion suscripcion : suscripcionRepository.findAll()) {
            SuscripcionDTO suscripcionDTO = mapper.toDTO(suscripcion);
            suscripcionesDTO.add(suscripcionDTO);
        }

        return suscripcionesDTO;
    }

    public SuscripcionDTO findById(Long idSuscripcion) {
        Suscripcion suscripcion =  suscripcionRepository.findById(idSuscripcion).orElse(null);
        return mapper.toDTO(suscripcion);
    }

    public Suscripcion save(Suscripcion suscripcion) {
        usuarioClient.findById(suscripcion.getIdUsuario());
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion update(Long idSuscripcion, Suscripcion suscripcionNueva) {

        if (suscripcionRepository.existsById(idSuscripcion)) {
            usuarioClient.findById(suscripcionNueva.getIdUsuario());

            Suscripcion suscripcion = suscripcionRepository.findById(idSuscripcion).orElse(null);

            suscripcion.setFechaInicio(suscripcionNueva.getFechaInicio());
            suscripcion.setFechaTermino(suscripcionNueva.getFechaTermino());
            suscripcion.setActivado(suscripcionNueva.getActivado());
            suscripcion.setPlan(suscripcionNueva.getPlan());
            suscripcion.setIdUsuario(suscripcionNueva.getIdUsuario());

            return suscripcionRepository.save(suscripcion);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idSuscripcion) {
        if(suscripcionRepository.existsById(idSuscripcion)) {
            suscripcionRepository.deleteById(idSuscripcion);
            return true;
        } else {
            return false;
        }
    }

}
