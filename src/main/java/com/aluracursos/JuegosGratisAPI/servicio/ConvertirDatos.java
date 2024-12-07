package com.aluracursos.JuegosGratisAPI.servicio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ConvertirDatos{
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ConvertirDatos() {
    objectMapper.registerModule(new JavaTimeModule());
    }

    public <T> T obtenerDatos(String json, TypeReference<T> typeRef) {
        try {
            return objectMapper.readValue(json, typeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
