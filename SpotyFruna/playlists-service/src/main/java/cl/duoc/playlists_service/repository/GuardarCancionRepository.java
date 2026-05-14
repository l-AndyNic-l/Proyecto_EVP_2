package cl.duoc.playlists_service.repository;

import cl.duoc.playlists_service.model.GuardarCancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardarCancionRepository extends JpaRepository<GuardarCancion, Long> {
    List<GuardarCancion> findAllById(Long id);
}
