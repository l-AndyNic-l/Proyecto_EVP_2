package cl.duoc.playlists_service.service;

import cl.duoc.playlists_service.model.Playlist;
import cl.duoc.playlists_service.model.GuardarCancion;
import cl.duoc.playlists_service.repository.PlaylistRepository;
import cl.duoc.playlists_service.repository.GuardarCancionRepository;
import cl.duoc.playlists_service.dto.PlaylistDTO;
import cl.duoc.playlists_service.dto.CancionDTO;
import cl.duoc.playlists_service.dto.UsuarioDTO;
import cl.duoc.playlists_service.clients.CancionClient;
import cl.duoc.playlists_service.clients.UsuarioClient;
import cl.duoc.playlists_service.mapper.PlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private GuardarCancionRepository guardarCancionRepository;

    @Autowired
    private CancionClient cancionClient;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private PlaylistMapper mapper;



    public List<PlaylistDTO> findAll() {
        List<PlaylistDTO> playlistsDTO = new ArrayList<>();

        for(Playlist p : playlistRepository.findAll()) {
            List<CancionDTO> canciones = new ArrayList<>();
            UsuarioDTO usuarioDTO = usuarioClient.findById(p.getIdUsuario());

            for(GuardarCancion guardarCancion : guardarCancionRepository.findAllById(p.getId())) {
                canciones.add(cancionClient.findById(guardarCancion.getIdCancion()));
            }

            PlaylistDTO p_dto = mapper.toDTO(p, canciones, usuarioDTO);
            playlistsDTO.add(p_dto);
        }

        return playlistsDTO;
    }

    public PlaylistDTO findById(Long id) {
        Playlist playlist = playlistRepository.findById( id ).orElse(null);
        UsuarioDTO usuarioDTO = usuarioClient.findById(playlist.getIdUsuario());
        List<CancionDTO> cancionesDTO = new ArrayList<>();

        for(GuardarCancion guardarCancion : guardarCancionRepository.findAllById(playlist.getId())) {
            cancionesDTO.add(cancionClient.findById(guardarCancion.getIdCancion()));
        }

        return mapper.toDTO(playlist, cancionesDTO, usuarioDTO);
    }

    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist update(Long idPlaylist, Playlist playlistNueva) {

        if (playlistRepository.existsById(idPlaylist)) {

            Playlist playlist = playlistRepository.findById(idPlaylist).orElse(null);

            playlist.setNombre(playlistNueva.getNombre());
            playlist.setDescripcion(playlistNueva.getDescripcion());
            playlist.setPrivacidad(playlistNueva.getPrivacidad());

            return playlistRepository.save(playlist);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idPlaylist) {
        if(playlistRepository.existsById(idPlaylist)) {
            playlistRepository.deleteById(idPlaylist);
            return true;
        } else {
            return false;
        }
    }

}
