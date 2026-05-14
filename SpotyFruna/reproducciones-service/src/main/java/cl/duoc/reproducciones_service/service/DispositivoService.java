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

    public Dispositivo findByNombre(String nombre) {
        return dispositivoRepository.findByNombre(nombre);
    }

    public Dispositivo save(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public Dispositivo update(Long idDispositivo,  Dispositivo dispositivoNuevo) {
        if( dispositivoRepository.existsById(idDispositivo)) {
            Dispositivo dispositivo = dispositivoRepository.findById(idDispositivo).orElse(null);

            dispositivo.setNombre(dispositivoNuevo.getNombre());

            return dispositivoRepository.save(dispositivo);
        } else {
            return null;
        }
    }

    public Boolean delete(Long idDispositivo) {
        if( dispositivoRepository.existsById(idDispositivo)) {
            dispositivoRepository.deleteById(idDispositivo);
            return true;
        } else {
            return false;
        }
    }

}
