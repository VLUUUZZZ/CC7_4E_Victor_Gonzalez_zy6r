package mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "videojuego")
@Data
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String plataforma;

    @Column(nullable = false)
    private boolean disponible = true;

}
