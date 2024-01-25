package com.example.repositories;

import com.example.models.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmDAO extends CrudRepository<Film, Long> {

}
