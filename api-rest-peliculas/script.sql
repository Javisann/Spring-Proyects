CREATE DATABASE IF NOT EXISTS peliculas;

USE peliculasdb;

CREATE TABLE pelicula (
    id BIGINT NOT NULL AUTO_INCREMENT,
    actores VARCHAR(255),
    agno INTEGER,
    director VARCHAR(255),
    genero VARCHAR(255),
    titulo VARCHAR(255),
    PRIMARY KEY (id)
);

LOAD DATA INFILE "ruta/peliculas.csv"
INTO TABLE pelicula
FIELDS TERMINATED BY ';'
IGNORE 1 ROWS
(titulo, genero, agno, director, actores);
