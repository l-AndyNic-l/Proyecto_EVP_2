package cl.duoc.usuarios_service.service;

import cl.duoc.usuarios_service.model.Usuario;
import cl.duoc.usuarios_service.repository.UsuarioRepository;
import cl.duoc.usuarios_service.dto.UsuarioDTO;
import cl.duoc.usuarios_service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper mapper;



    public List<UsuarioDTO> findAll() {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for(Usuario usuario : usuarioRepository.findAll()) {
            UsuarioDTO usuarioDTO = mapper.toDTO(usuario);
            usuariosDTO.add(usuarioDTO);
        }

        return usuariosDTO;
    }

    public UsuarioDTO findById(Long idUsuario) {
        Usuario usuario =  usuarioRepository.findById(idUsuario).orElse(null);
        return mapper.toDTO(usuario);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long idUsuario, Usuario usuarioNuevo) {
        if (usuarioRepository.existsById(idUsuario)) {
            Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

            usuario.setNombre(usuarioNuevo.getNombre());
            usuario.setApellido(usuarioNuevo.getApellido());
            usuario.setNickname(usuarioNuevo.getNickname());
            usuario.setEmail(usuarioNuevo.getEmail());
            usuario.setPassword(usuarioNuevo.getPassword());
            usuario.setFechaNacimiento(usuarioNuevo.getFechaNacimiento());
            usuario.setCelular(usuarioNuevo.getCelular());
            usuario.setTipoUsuario(usuarioNuevo.getTipoUsuario());
            
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idUsuario) {
        if( usuarioRepository.existsById(idUsuario) ) {
            usuarioRepository.deleteById(idUsuario);
            return true;
        } else {
            return false;
        }
    }

}
