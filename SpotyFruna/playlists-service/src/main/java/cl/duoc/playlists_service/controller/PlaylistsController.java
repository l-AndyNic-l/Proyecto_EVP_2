package cl.duoc.playlists_service.controller;

import cl.duoc.playlists_service.dto.PlaylistDTO;
import cl.duoc.playlists_service.model.Playlist;
import cl.duoc.playlists_service.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/api/v1/playlists" )
public class PlaylistsController {

    @Autowired
    private PlaylistService playlistService;



    @GetMapping
    public List<PlaylistDTO> findAll() {
        return playlistService.findAll();
    }

    @GetMapping( "/{idPlaylist}" )
    public PlaylistDTO findById(@PathVariable Long idPlaylist) {
        return playlistService.findById(idPlaylist);
    }

    @PostMapping
    public Playlist save(@RequestBody Playlist playlist) {
        return playlistService.save(playlist);
    }

    @PutMapping( "/{idPlaylist}" )
    public Playlist update(@PathVariable Long idPlaylist, @RequestBody Playlist playlist) {
        return playlistService.update(idPlaylist, playlist);
    }

    @DeleteMapping("/{idPlaylist}")
    public Boolean delete(@PathVariable Long idPlaylist) {
        return playlistService.deleteById(idPlaylist);
    }


}
