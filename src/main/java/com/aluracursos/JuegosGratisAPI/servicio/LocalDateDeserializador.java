package com.aluracursos.JuegosGratisAPI.servicio;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateDeserializador extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText();
        try {
            if(date.endsWith("-00")){
                date = date.substring(0, date.length() - 1) + 01;
            }

            // Intentar parsear la fecha si es válida
            return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            // Si la fecha es inválida, retornamos null o podrías lanzar una excepción
            System.err.println("Fecha inválida encontrada: " + date + ". Se establecerá en null.");
            return null;
        }
    }

}
