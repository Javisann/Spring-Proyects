package com.example.services;

import com.example.models.Film;
import com.example.repositories.FilmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FilmServices {

    @Autowired
    FilmDAO filmRepository;

    public ArrayList<Film> obtainFilms(){
        return (ArrayList<Film>) filmRepository.findAll();
    }

    public Film addFilm(Film film){
        return filmRepository.save(film);
    }

    public boolean deleteFilmById(Long id){
        try{
            filmRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
