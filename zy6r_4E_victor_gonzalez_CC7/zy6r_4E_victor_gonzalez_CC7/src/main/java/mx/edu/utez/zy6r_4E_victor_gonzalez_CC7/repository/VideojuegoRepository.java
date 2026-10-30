package mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.repository;

import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    List<Videojuego> findByDisponibleTrue();
}
