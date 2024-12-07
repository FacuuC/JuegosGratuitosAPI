package com.aluracursos.JuegosGratisAPI.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.aluracursos.JuegosGratisAPI.servicio.LocalDateDeserializador;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosJuegos(@JsonAlias("title") String titulo,
                          @JsonAlias("short_description") String descripcion,
                          @JsonAlias("genre") String genero,
                          @JsonAlias("platform") String plataforma,
                          @JsonAlias("publisher") String distribuidor,
                          @JsonAlias("release_date")  @JsonDeserialize(using = LocalDateDeserializador.class)  LocalDate fechaDeLanzamiento) {
    @Override
    public String toString() {
        return "(Titulo:  " + titulo + " / " +
                "Descripción:  (" + descripcion + ") / "+
                "Genero:  " + genero + " / "+
                "Plataforma:  " + plataforma + " / "+
                "Distribuidor:  " + distribuidor + " / "+
                "Fecha de lanzamiento:  " + fechaDeLanzamiento + " / ";
    }

    @Override
    public String descripcion() {
        return descripcion;
    }

    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public String genero() {
        return genero;
    }

    @Override
    public String plataforma() {
        return plataforma;
    }

    @Override
    public String distribuidor() {
        return distribuidor;
    }

    @Override
    public LocalDate fechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }
}

