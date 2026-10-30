package mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.DTO;

import lombok.Data;

@Data
public class PrestamoRequestDTO {
    @NotNull(message = "El ID del videojuego no puede ser nulo")
    private Long videojuegoId;

    @NotBlank(message = "El nombre del solicitante no puede estar vacío")
    private String nombreSolicitante;
}

