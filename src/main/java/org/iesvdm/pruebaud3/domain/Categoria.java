package org.iesvdm.pruebaud3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private int idCat;
    private String nombre;
    private LocalDate ultimaActualizacion;
}
