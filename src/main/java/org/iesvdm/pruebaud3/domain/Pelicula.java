package org.iesvdm.pruebaud3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String descipcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLanzamiento;
    private int idIdioma;
    private int duracionAlquiler;
    private Double rentalRate;
    private int duracion;
    private Double replacementCost;
    private LocalDate ultimaActualizacion;

}
