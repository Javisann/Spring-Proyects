# API REST de Peliculas

API REST hecha con Spring Boot.

*Para probar este programa debera implementar un script el cual estara adjunto con los archivos como 'script.sql'. Este archivo te creara la base de datos e implementara la tabla y todas las peliculas.*

```
CREATE DATABASE IF NOT EXISTS peliculasdb;

USE peliculasdb;

CREATE TABLE peliculas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255),
    genero VARCHAR(255),
    agno INTEGER,
    director VARCHAR(255),
    actores VARCHAR(255),
    PRIMARY KEY (id)
);

LOAD DATA INFILE "ruta/peliculas.csv"
INTO TABLE peliculas
FIELDS TERMINATED BY ';'
IGNORE 1 ROWS
(titulo, genero, agno, director, actores);
```
