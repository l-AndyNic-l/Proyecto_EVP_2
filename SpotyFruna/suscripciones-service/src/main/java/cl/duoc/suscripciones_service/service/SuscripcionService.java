package cl.duoc.suscripciones_service.service;

import cl.duoc.suscripciones_service.clients.UsuarioClient;
import cl.duoc.suscripciones_service.model.Suscripcion;
import cl.duoc.suscripciones_service.mapper.SuscripcionMapper;
import cl.duoc.suscripciones_service.dto.SuscripcionDTO;
import cl.duoc.suscripciones_service.repository.SuscripcionRepository;
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
        List<SuscripcionDTO> listado = new ArrayList<>();

        for(Suscripcion s : suscripcionRepository.findAll()) {
            SuscripcionDTO s_dto = mapper.toDTO(s);
            listado.add(s_dto);
        }

        return listado;
    }

    public SuscripcionDTO findById(Long id) {
        Suscripcion s =  suscripcionRepository.findById(id).orElse(null);
        return mapper.toDTO(s);
    }

    public Suscripcion save(Suscripcion s) {
        usuarioClient.findById(s.getId_usuario());
        return suscripcionRepository.save(s);
    }

    public Suscripcion update(Long id, Suscripcion s) {

        if (suscripcionRepository.existsById(id)) {

            usuarioClient.findById(s.getId_usuario());

            Suscripcion suscripcion = suscripcionRepository.findById(id).orElse(null);
            suscripcion.setFechaInicio(s.getFechaInicio());
            suscripcion.setFechaTermino(s.getFechaTermino());
            suscripcion.setActivado(s.getActivado());
            suscripcion.setPlan(s.getPlan());
            suscripcion.setId_usuario(s.getId_usuario());

            return suscripcionRepository.save(suscripcion);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if(suscripcionRepository.existsById(id)) {
            suscripcionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
