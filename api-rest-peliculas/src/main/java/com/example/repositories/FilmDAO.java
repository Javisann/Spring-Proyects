package com.example.repositories;

import com.example.models.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDAO extends CrudRepository<Film, Long> {
}
