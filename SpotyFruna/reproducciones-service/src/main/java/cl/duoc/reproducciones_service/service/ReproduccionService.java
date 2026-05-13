package cl.duoc.reproducciones_service.service;

import cl.duoc.reproducciones_service.clients.CancionFeing;
import cl.duoc.reproducciones_service.clients.UsuarioFeing;
import cl.duoc.reproducciones_service.dto.CancionDTO;
import cl.duoc.reproducciones_service.dto.ReproduccionDTO;
import cl.duoc.reproducciones_service.dto.UsuarioDTO;
import cl.duoc.reproducciones_service.mapper.ReproduccionMapper;
import cl.duoc.reproducciones_service.model.Reproduccion;
import cl.duoc.reproducciones_service.repository.ReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReproduccionService {

    @Autowired
    private ReproduccionRepository reproduccionRepository;

    @Autowired
    private UsuarioFeing usuarios;

    @Autowired
    private CancionFeing canciones;

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

    public ReproduccionDTO findById( Long id ) {
        Reproduccion reproduccion = reproduccionRepository.findById( id ).orElse(null);
        CancionDTO cancionDTO = canciones.findById( reproduccion.getCancion() );
        UsuarioDTO usuarioDTO = usuarios.findById( reproduccion.getUsuario() );

        return mapper.toDTO( reproduccion, cancionDTO, usuarioDTO );
    }

    public Reproduccion save( Reproduccion r ) {
        return reproduccionRepository.save(r);
    }

    public Reproduccion update( Long id,  Reproduccion r ) {
        if( reproduccionRepository.existsById( id ) ) {

            Reproduccion reproduccion = reproduccionRepository.findById( id ).orElse(null);
            reproduccion.setSegundosEscuchados( r.getSegundosEscuchados() );

            return reproduccionRepository.save( reproduccion );

        } else {
            return null;
        }
    }

    public Boolean delete( Long id ) {
        if( reproduccionRepository.existsById( id ) ) {

            reproduccionRepository.deleteById( id );
            return true;

        } else {
            return false;
        }
    }

}
