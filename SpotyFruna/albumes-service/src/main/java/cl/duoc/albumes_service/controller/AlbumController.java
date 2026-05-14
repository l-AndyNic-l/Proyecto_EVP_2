package cl.duoc.albumes_service.controller;

import cl.duoc.albumes_service.dto.AlbumDTO;
import cl.duoc.albumes_service.model.Album;
import cl.duoc.albumes_service.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/albumes" )
public class AlbumController {

    @Autowired
    private AlbumService albumService;



    @GetMapping
    public List<AlbumDTO> findAll() {
        return albumService.findAll();
    }

    @GetMapping("/{idAlbum}")
    public AlbumDTO findById(@PathVariable Long idAlbum) {
        return albumService.findById(idAlbum);
    }

    @PostMapping
    public Album save(@RequestBody Album album) {
        return albumService.save(album);
    }

    @PutMapping("/{idAlbum}")
    public Album update(@PathVariable Long idAlbum, @RequestBody Album album) {
        return albumService.update(idAlbum, album);
    }

    @DeleteMapping("/{idAlbum}")
    public Boolean delete(@PathVariable Long idAlbum) {
        return albumService.deleteById(idAlbum);
    }

}
