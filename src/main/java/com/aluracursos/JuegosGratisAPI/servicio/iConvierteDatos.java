package com.aluracursos.JuegosGratisAPI.servicio;

public interface iConvierteDatos {
    <T> T obtenerDatos (String json, Class<T> clase);
}
