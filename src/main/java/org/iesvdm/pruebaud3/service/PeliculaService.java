package org.iesvdm.pruebaud3.service;

import org.iesvdm.pruebaud3.dao.PeliculaDAO;
import org.iesvdm.pruebaud3.domain.Categoria;
import org.iesvdm.pruebaud3.domain.Idioma;
import org.iesvdm.pruebaud3.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements ServiceBase<Pelicula> {
    @Autowired
    private PeliculaDAO<Pelicula> peliculaDAO;


    @Override
    public List<Pelicula> listAll() {
        return peliculaDAO.getAll();
    }


    @Override
    public Pelicula one(int id) {
        return null;
    }

    @Override
    public void create(Pelicula pelicula) {
        peliculaDAO.create(pelicula);
    }

    @Override
    public void replace(Pelicula pelicula) {

    }

    @Override
    public void delete(int id) {

    }

    public List<Idioma> getIdiomas() {
        return peliculaDAO.getAllIdiomas();
    }

    public List<Categoria> getCategorias() {
        return peliculaDAO.getAllACategorias();
    }
}
