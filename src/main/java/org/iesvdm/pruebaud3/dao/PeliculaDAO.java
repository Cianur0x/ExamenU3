package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.domain.Categoria;
import org.iesvdm.pruebaud3.domain.Idioma;

import java.util.List;
import java.util.Optional;

public interface PeliculaDAO<Pelicula> extends RepositoryBase<Pelicula> {
    public List<Idioma> getAllIdiomas();

    public List<Categoria> getAllACategorias();
}
