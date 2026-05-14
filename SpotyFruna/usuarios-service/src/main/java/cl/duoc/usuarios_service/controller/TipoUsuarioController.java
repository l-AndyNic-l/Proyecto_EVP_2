package cl.duoc.usuarios_service.controller;

import cl.duoc.usuarios_service.model.TipoUsuario;
import cl.duoc.usuarios_service.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/tipos_usuarios" )
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;



    @GetMapping
    public List<TipoUsuario> findAll() {
        return tipoUsuarioService.findAll();
    }

    @GetMapping( "/{tipo}" )
    public TipoUsuario findOne(@PathVariable String tipo) {
        return tipoUsuarioService.findByNombre(tipo);
    }

    @PostMapping
    public TipoUsuario save(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.save(tipoUsuario);
    }

    @PutMapping( "/{idTipoUsuario}" )
    public TipoUsuario update(@PathVariable Long idTipoUsuario, @RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.update(idTipoUsuario, tipoUsuario);
    }

    @DeleteMapping( "/{idTipoUsuario}" )
    public Boolean deleteById(@PathVariable Long idTipoUsuario){
        return tipoUsuarioService.deleteById(idTipoUsuario);
    }

}
