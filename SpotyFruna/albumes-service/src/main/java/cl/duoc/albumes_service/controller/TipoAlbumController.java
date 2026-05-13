package cl.duoc.albumes_service.controller;

import cl.duoc.albumes_service.model.TipoAlbum;
import cl.duoc.albumes_service.service.TipoAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/api/v1/tipo-albumes" )
public class TipoAlbumController {

    @Autowired
    private TipoAlbumService tipoAlbumService;

    @GetMapping
    public List<TipoAlbum> findAll() {
        return tipoAlbumService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoAlbum> findById(@PathVariable Long id ) {
        return tipoAlbumService.findById(id);
    }

    @PostMapping
    public TipoAlbum save(@RequestBody TipoAlbum a) {
        return tipoAlbumService.save(a);
    }

    @PutMapping("/{id}")
    public TipoAlbum update(@PathVariable Long id, @RequestBody TipoAlbum ta) {
        return tipoAlbumService.update(id, ta);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return tipoAlbumService.deleteById(id);
    }

}

