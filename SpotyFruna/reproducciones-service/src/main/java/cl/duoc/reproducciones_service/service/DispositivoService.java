package cl.duoc.reproducciones_service.service;

import cl.duoc.reproducciones_service.model.Dispositivo;
import cl.duoc.reproducciones_service.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<Dispositivo> findAll() {
        return dispositivoRepository.findAll();
    }

    public Dispositivo findByNombre( String nombre ) {
        return dispositivoRepository.findByNombre(nombre);
    }

    public Dispositivo save( Dispositivo d ) {
        return dispositivoRepository.save(d);
    }

    public Dispositivo update( Long id,  Dispositivo d ) {
        if( dispositivoRepository.existsById( id ) ) {

            Dispositivo dispositivo = dispositivoRepository.findById(id).orElse(null);
            dispositivo.setNombre( d.getNombre() );

            return dispositivoRepository.save(dispositivo);

        } else {
            return null;
        }
    }

    public Boolean delete( Long id ) {
        if( dispositivoRepository.existsById( id ) ) {

            dispositivoRepository.deleteById( id );
            return true;

        } else {
            return false;
        }
    }

}
