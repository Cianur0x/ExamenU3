package org.iesvdm.pruebaud3.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebaud3.domain.Categoria;
import org.iesvdm.pruebaud3.domain.Idioma;
import org.iesvdm.pruebaud3.domain.Pelicula;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class PeliculaDAOImpl implements PeliculaDAO<Pelicula> {

    private final JdbcTemplate jdbcTemplate;

    public PeliculaDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Pelicula pelicula) {
        log.info(pelicula.toString());
        jdbcTemplate.update("INSERT INTO pelicula (titulo, descripcion, fecha_lanzamiento, id_idioma, duracion_alquiler, rental_rate, duracion, replacement_cost, ultima_actualizacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                pelicula.getTitulo(), pelicula.getDescipcion(), pelicula.getFechaLanzamiento(), pelicula.getIdIdioma(), pelicula.getDuracionAlquiler(), pelicula.getRentalRate(), pelicula.getDuracion(), pelicula.getReplacementCost(), LocalDate.now());
    }

    @Override
    public List<Pelicula> getAll() {
        List<Pelicula> comercialList = jdbcTemplate.query(
                "SELECT * FROM pelicula",
                (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"), rs.getString("titulo"), rs.getString("descripcion"), rs.getDate("fecha_lanzamiento").toLocalDate(), rs.getInt("id_idioma"), rs.getInt("duracion_alquiler"), rs.getDouble("rental_rate"), rs.getInt("duracion"), rs.getDouble("replacement_cost"), rs.getDate("ultima_actualizacion").toLocalDate())
        );

        return comercialList;
    }

    @Override
    public Optional<Pelicula> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Idioma> getAllIdiomas() {
        List<Idioma> idioma = jdbcTemplate.query(
                "SELECT * FROM idioma",
                (rs, rowNum) -> new Idioma(rs.getInt("id_idioma"), rs.getString("nombre"), rs.getDate("ultima_actualizacion").toLocalDate())
        );

        return idioma;
    }

    @Override
    public List<Categoria> getAllACategorias() {
        List<Categoria> categoriaList = jdbcTemplate.query(
                "SELECT * FROM categoria",
                (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"), rs.getString("nombre"), rs.getDate("ultima_actualizacion").toLocalDate())
        );

        return categoriaList;
    }


}
