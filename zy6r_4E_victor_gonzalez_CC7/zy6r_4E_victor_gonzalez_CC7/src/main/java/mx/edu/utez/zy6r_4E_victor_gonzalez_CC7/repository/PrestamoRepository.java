package mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.repository;

import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.model.EstadoPrestamo;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByVideojuegoIdAndEstado(Long videojuegoId, EstadoPrestamo estado);
    List<Prestamo> findByEstado(EstadoPrestamo estado);
}
