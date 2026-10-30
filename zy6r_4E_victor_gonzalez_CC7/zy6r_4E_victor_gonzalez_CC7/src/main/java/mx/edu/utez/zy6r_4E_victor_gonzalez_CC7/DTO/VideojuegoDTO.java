package mx.edu.utez.zy6r_4E_victor_gonzalez_CC7.DTO;

import lombok.Data;

@Data
public class VideojuegosDTO {
    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "La plataforma es obligatoria")
    private String plataforma;
}

