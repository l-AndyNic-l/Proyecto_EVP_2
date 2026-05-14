package cl.duoc.reproducciones_service.service;

import cl.duoc.reproducciones_service.model.Reproduccion;
import cl.duoc.reproducciones_service.repository.ReproduccionRepository;
import cl.duoc.reproducciones_service.dto.ReproduccionDTO;
import cl.duoc.reproducciones_service.dto.CancionDTO;
import cl.duoc.reproducciones_service.dto.UsuarioDTO;
import cl.duoc.reproducciones_service.clients.CancionClient;
import cl.duoc.reproducciones_service.clients.UsuarioClient;
import cl.duoc.reproducciones_service.mapper.ReproduccionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReproduccionService {

    @Autowired
    private ReproduccionRepository reproduccionRepository;

    @Autowired
    private UsuarioClient usuarios;

    @Autowired
    private CancionClient canciones;

    @Autowired
    private ReproduccionMapper mapper;



    public List<ReproduccionDTO> findAll() {
        List<ReproduccionDTO> reproducciones = new ArrayList<>();

        for( Reproduccion r : reproduccionRepository.findAll() ) {
            CancionDTO cancionDTO = canciones.findById( r.getCancion() );
            UsuarioDTO usuarioDTO = usuarios.findById( r.getUsuario() );
            ReproduccionDTO reproduccionDTO = mapper.toDTO( r, cancionDTO, usuarioDTO );

            reproducciones.add( reproduccionDTO );
        }

        return reproducciones;
    }

    public ReproduccionDTO findById(Long idReproduccion) {
        Reproduccion reproduccion = reproduccionRepository.findById(idReproduccion).orElse(null);

        CancionDTO cancionDTO = canciones.findById(reproduccion.getCancion());
        UsuarioDTO usuarioDTO = usuarios.findById(reproduccion.getUsuario());

        return mapper.toDTO( reproduccion, cancionDTO, usuarioDTO );
    }

    public Reproduccion save(Reproduccion reproduccion) {
        return reproduccionRepository.save(reproduccion);
    }

    public Reproduccion update(Long idReproduccion, Reproduccion reproduccionNueva) {
        if (reproduccionRepository.existsById(idReproduccion)) {
            Reproduccion reproduccion = reproduccionRepository.findById(idReproduccion).orElse(null);

            reproduccion.setSegundosEscuchados(reproduccionNueva.getSegundosEscuchados());

            return reproduccionRepository.save(reproduccion);
        } else {
            return null;
        }
    }

    public Boolean delete( Long idReproduccion ) {
        if( reproduccionRepository.existsById( idReproduccion ) ) {
            reproduccionRepository.deleteById( idReproduccion );
            return true;
        } else {
            return false;
        }
    }

}
