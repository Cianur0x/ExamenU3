package org.iesvdm.pruebaud3.domain;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaForm {

    private int idPelicula;

    @NotBlank(message = "{error.blank}")
    @Size(min = 3, message = "{titulo.error.size}")
    private String titulo;

    @NotBlank(message = "{error.blank}")
    @Size(max = 300, message = "{descripcion.error.size}")
    private String descipcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLanzamiento;

    private int idIdioma;

    private int idCategoria;

    private int duracionAlquiler;

    @Min(value = 0, message = "{renta.error}")
    private Double rentalRate;

    @Min(value = 1, message = "{duraccion.error}")
    private int duracion;

    @DecimalMin(value = "19.99", message = "{remplazo.error}")
    private Double replacementCost;

}
