package com.example.services;

import com.example.models.Film;
import com.example.repositories.FilmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmDAO filmRepository;

    @Override
    public ArrayList<Film> obtainFilms(){
        return (ArrayList<Film>) filmRepository.findAll();
    }


    @Override
    public Optional<Film> findById(Long id) {
        return this.filmRepository.findById(id);
    }

    @Override
    public Film addFilm(Film film){
        return filmRepository.save(film);
    }

    @Override
    public boolean deleteFilmById(Long id){
        try{
            filmRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
