package cl.duoc.usuarios_service.controller;

import cl.duoc.usuarios_service.dto.UsuarioDTO;
import cl.duoc.usuarios_service.model.Usuario;
import cl.duoc.usuarios_service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/api/v1/usuarios" )
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping
    public List<UsuarioDTO> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping( "/{idUsuario}" )
    public UsuarioDTO findById( @PathVariable Long idUsuario) {
        return usuarioService.findById(idUsuario);
    }

    @PostMapping
    public Usuario save( @RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping( "/{idUsuario}" )
    public Usuario update( @PathVariable Long idUsuario, @RequestBody Usuario usuario) {
        return usuarioService.update(idUsuario, usuario);
    }

    @DeleteMapping( "/{idUsuario}" )
    public Boolean delete( @PathVariable Long idUsuario) {
        return usuarioService.deleteById(idUsuario);
    }

}
