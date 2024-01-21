package com.example.controllers;

import com.example.models.Film;
import com.example.services.FilmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmServices filmServices;

    @GetMapping()
    public ArrayList<Film> obtainFilm(){
        return filmServices.obtainFilms();
    }

    @PostMapping()
    public Film addFilm(@RequestBody Film film){
        return filmServices.addFilm(film);
    }

    @DeleteMapping(path="{id}")
    public String deleteFilm(@PathVariable("id") Long id){
        boolean ok = filmServices.deleteFilmById(id);
        if(ok){
            return "Se elimino correctamente";
        }else{
            return "No se pudo eliminar";
        }
    }
}
