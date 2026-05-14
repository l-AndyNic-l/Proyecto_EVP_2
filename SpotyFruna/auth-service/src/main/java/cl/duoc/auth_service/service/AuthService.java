package cl.duoc.auth_service.service;

import cl.duoc.auth_service.model.Auth;
import cl.duoc.auth_service.repository.AuthRepository;
import cl.duoc.auth_service.dto.AuthDTO;
import cl.duoc.auth_service.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AuthMapper mapper;



    public List<AuthDTO>  findAll() {
        List<AuthDTO> authsDTO = new ArrayList<>();

        for (Auth auth : authRepository.findAll()) {
            AuthDTO authDTO = mapper.toDTO(auth);
            authsDTO.add(authDTO);
        }

        return authsDTO;
    }

    public List<AuthDTO> findAllByUsuario(Long idUsuario) {
        List<AuthDTO> authsDTO = new ArrayList<>();

        for (Auth auth : authRepository.findAllByUsuario(idUsuario)) {
            AuthDTO authDTO = mapper.toDTO(auth);
            authsDTO.add(authDTO);
        }

        return authsDTO;
    }

    public List<AuthDTO> findAllByAnio(int anio) {
        List<AuthDTO> authsDTO = new ArrayList<>();

        for(Auth auth : authRepository.findAllByAnio(anio)) {
            AuthDTO authDTO = mapper.toDTO(auth);
            authsDTO.add(authDTO);
        }

        return authsDTO;
    }

    public List<AuthDTO> findAllByMes(int mes, int anio) {
        List<AuthDTO> authsDTO = new ArrayList<>();

        for(Auth auth : authRepository.findAllByMes(mes, anio)) {
            AuthDTO authDTO = mapper.toDTO(auth);
            authsDTO.add(authDTO);
        }

        return authsDTO;
    }

    public List<AuthDTO> findAllByDia(int dia, int mes, int anio) {
        List<AuthDTO> authsDTO = new ArrayList<>();

        for(Auth auth : authRepository.findAllByDia(dia, mes, anio)) {
            AuthDTO authDTO = mapper.toDTO(auth);
            authsDTO.add(authDTO);
        }

        return authsDTO;
    }

    public List<AuthDTO> findAllByEntreFechas(String fecha_ini, String fecha_ter) {
        List<AuthDTO> authsDTO = new ArrayList<>();

        for(Auth auth : authRepository.findAllByEntreFechas(fecha_ini, fecha_ter)) {
            AuthDTO authDTO = mapper.toDTO(auth);
            authsDTO.add(authDTO);
        }

        return authsDTO;
    }

    public Auth save(Auth auth) {
        return authRepository.save(auth);
    }

    public Auth update(Long idAuth, Auth authNuevo) {
        if (authRepository.existsById(idAuth)) {
            Auth auth = authRepository.findById( idAuth ).orElse(null);

            auth.setEstado( authNuevo.getEstado() );
            auth.setFechaExpiracion( authNuevo.getFechaExpiracion() );

            return authRepository.save(auth);
        } else {
            return null;
        }
    }

}
