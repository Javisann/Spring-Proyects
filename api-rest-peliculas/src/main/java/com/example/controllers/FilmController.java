package com.example.controllers;

import com.example.models.Film;
import com.example.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {
    @Autowired
    FilmService filmServices;

    @GetMapping("/films")
    public ResponseEntity<List<Film>> obtainFilm(){
        List<Film> films = this.filmServices.obtainFilms();
        if(films.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(films);
        }
    }



    @GetMapping("/films/{id}")
    public ResponseEntity<Film> findById(@PathVariable Long id) {
        return this.filmServices.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/films")
    public ResponseEntity<Film> addFilm(@RequestBody Film film){
        //comprobaciones
        if(film.getId() != null){
            return ResponseEntity.badRequest().build();
        }else{
            this.filmServices.addFilm(film);
            return ResponseEntity.ok(film);
        }
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable Long id){
        this.filmServices.deleteFilmById(id);
        return ResponseEntity.noContent().build();
    }
}
