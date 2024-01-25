package com.example.services;

import com.example.models.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface FilmService {

    public ArrayList<Film> obtainFilms();



    Optional<Film> findById(Long id);

    public Film addFilm(Film film);

    public boolean deleteFilmById(Long id);

}
