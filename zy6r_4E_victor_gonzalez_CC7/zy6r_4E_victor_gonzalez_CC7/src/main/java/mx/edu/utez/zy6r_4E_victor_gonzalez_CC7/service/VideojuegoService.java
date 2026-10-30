package mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.service;

import jakarta.transaction.Transactional;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.DTO.VideojuegosDTO;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.exception.ResourceNotFoundException;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.model.EstadoPrestamo;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.model.Prestamo;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.model.Videojuego;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.repository.PrestamoRepository;
import mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.repository.VideojuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {
    private final VideojuegoRepository videojuegoRepository;
    private final PrestamoRepository prestamoRepository;

    public VideojuegoService(VideojuegoRepository videojuegoRepository, PrestamoRepository prestamoRepository) {
        this.videojuegoRepository = videojuegoRepository;
        this.prestamoRepository = prestamoRepository;
    }
    public Videojuego crear(VideojuegosDTO dto) {
        Videojuego v = new Videojuego();
        v.setTitulo(dto.getTitulo());
        v.setPlataforma(dto.getPlataforma());
        v.setDisponible(true);
        return videojuegoRepository.save(v);
    }

    public List<Videojuego> listarDisponibles() {
        return videojuegoRepository.findByDisponibleTrue();
    }

    public List<Videojuego> listarCatalogoCompleto() {
        return videojuegoRepository.findAll();
    }

    @Transactional
    public void cancelarPrestamosActivosPorVideojuego(Long videojuegoId) {
        Videojuego videojuego = videojuegoRepository.findById(videojuegoId)
                .orElseThrow(() -> new ResourceNotFoundException("Videojuego no encontrado"));

        List<Prestamo> activos = prestamoRepository.findByVideojuegoIdAndEstado(videojuegoId, EstadoPrestamo.ACTIVO);

        for (Prestamo prestamo : activos) {
            prestamo.setEstado(EstadoPrestamo.CANCELADO);
            prestamoRepository.save(prestamo);
        }

        videojuego.setDisponible(true);
        videojuegoRepository.save(videojuego);
    }

}
