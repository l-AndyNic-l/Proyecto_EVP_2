package cl.duoc.playlists_service.service;

import cl.duoc.playlists_service.clients.CancionClient;
import cl.duoc.playlists_service.clients.UsuariosFeign;
import cl.duoc.playlists_service.dto.CancionDTO;
import cl.duoc.playlists_service.dto.PlaylistDTO;
import cl.duoc.playlists_service.dto.UsuarioDTO;
import cl.duoc.playlists_service.mapper.PlaylistMapper;
import cl.duoc.playlists_service.model.GuardarCancion;
import cl.duoc.playlists_service.model.Playlist;
import cl.duoc.playlists_service.repository.PlaylistCancionRepository;
import cl.duoc.playlists_service.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistCancionRepository playlistCancionRepository;

    @Autowired
    private CancionClient cancionClient;

    @Autowired
    private UsuariosFeign usuariosFeign;

    @Autowired
    private PlaylistMapper mapper;

    public List<PlaylistDTO> findAll() {
        List<PlaylistDTO> listado = new ArrayList<>();

        for(Playlist p : playlistRepository.findAll()) {
            List<CancionDTO> canciones = new ArrayList<>();
            UsuarioDTO usuarioDTO = usuariosFeign.findById(p.getUsuario());

            for( GuardarCancion g : playlistCancionRepository.findAllById( p.getId() ) ) {
                canciones.add( cancionClient.findById( g.getIdCancion() ) );
            }

            PlaylistDTO p_dto = mapper.toDTO(p, canciones, usuarioDTO);
            listado.add(p_dto);
        }

        return listado;
    }

    public PlaylistDTO findById(Long id) {
        Playlist playlist = playlistRepository.findById( id ).orElse(null);
        UsuarioDTO usuarioDTO = usuariosFeign.findById(playlist.getUsuario());
        List<CancionDTO> canciones = new ArrayList<>();

        for(GuardarCancion g : playlistCancionRepository.findAllById( playlist.getId() ) ) {
            canciones.add( cancionClient.findById( g.getIdCancion() ) );
        }

        return mapper.toDTO(playlist, canciones, usuarioDTO);
    }

    public Playlist save(Playlist p) {
        return playlistRepository.save(p);
    }

    public Playlist update(Long id, Playlist p) {

        if (playlistRepository.existsById(id)) {

            Playlist playlist = playlistRepository.findById(id).orElse(null);

            playlist.setNombre(p.getNombre());
            playlist.setDescripcion(p.getDescripcion());
            playlist.setPrivacidad(p.getPrivacidad());

            return playlistRepository.save(playlist);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if(playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
