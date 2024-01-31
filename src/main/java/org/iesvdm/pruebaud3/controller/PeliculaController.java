package org.iesvdm.pruebaud3.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebaud3.domain.Categoria;
import org.iesvdm.pruebaud3.domain.Idioma;
import org.iesvdm.pruebaud3.domain.Pelicula;
import org.iesvdm.pruebaud3.domain.PeliculaForm;
import org.iesvdm.pruebaud3.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping({"/peliculas", "/movie"})
    public String listar(Model model) {

        List<Pelicula> peliculaList = peliculaService.listAll();

        model.addAttribute("listaPelis", peliculaList);

        // TODO hacer una calse donde idioma sea un string un DTO??
        return "peliculas";
    }

    @GetMapping("/peliculas/crear")
    public String crear(Model model) {

        PeliculaForm peliculaForm = new PeliculaForm();
        model.addAttribute("peliculaForm", peliculaForm);
        List<Idioma> idiomas = peliculaService.getIdiomas();
        model.addAttribute("idiomas", idiomas);
        List<Categoria> categorias = peliculaService.getCategorias();
        model.addAttribute("categorias", categorias);

        return "crear-pelicula";
    }

    /**
     * Maneja las solicitudes POST para procesar la creación de un nuevo pelicula.
     *
     * @param peliculaForm El objeto Cliente que contiene la información del pelicula a ser creado.
     * @return Una redirección a la lista de clientes después de la creación.
     */
    @PostMapping("/peliculas/crear")
    public String submitCrear(@Valid @ModelAttribute("peliculaForm") PeliculaForm peliculaForm, BindingResult bindingResulted, Model model) {

        if (bindingResulted.hasErrors()) {
            model.addAttribute("peliculaForm", peliculaForm);
            List<Idioma> idiomas = peliculaService.getIdiomas();
            model.addAttribute("idiomas", idiomas);
            List<Categoria> categorias = peliculaService.getCategorias();
            model.addAttribute("categorias", categorias);
            log.info("ola crear pelicula" + peliculaForm.toString());
            return "crear-pelicula";
        }

        Pelicula pelicula = new Pelicula(0, peliculaForm.getTitulo(), peliculaForm.getDescipcion(), peliculaForm.getFechaLanzamiento(), peliculaForm.getIdIdioma(), peliculaForm.getDuracionAlquiler(), peliculaForm.getRentalRate(), peliculaForm.getDuracion(), peliculaForm.getReplacementCost(), LocalDate.now());
        log.info("ola crear pelicula" + pelicula);
        peliculaService.create(pelicula);
        return "redirect:/peliculas";
    }

}
