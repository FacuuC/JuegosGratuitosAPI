package com.aluracursos.JuegosGratisAPI.calculos;

import com.aluracursos.JuegosGratisAPI.modelo.DatosJuegos;

import java.util.List;

public class FiltroGenero {
    public void FiltrarGenero (List<DatosJuegos> datos, int generoElegido){
        switch (generoElegido){
            case 1:
                datos.stream()
                        .filter(d -> d.genero().equals("Shooter"))
                        .forEach(System.out::println);
                break;
            case 2:
                datos.stream()
                        .filter(d -> d.genero().equals("MMORPG"))
                        .forEach(System.out::println);
                break;
            case 3:
                datos.stream()
                        .filter(d -> d.genero().equals("Strategy"))
                        .forEach(System.out::println);
                break;
            case 4:
                datos.stream()
                        .filter(d -> d.genero().equals("Action RPG"))
                        .forEach(System.out::println);
                break;
            case 5:
                datos.stream()
                        .filter(d -> d.genero().equals("Battle Royale"))
                        .forEach(System.out::println);
                break;
            case 6:
                datos.stream()
                        .filter(d -> d.genero().equals("ARPG"))
                        .forEach(System.out::println);
                break;
            case 7:
                datos.stream()
                        .filter(d -> d.genero().equals("MMOARPG"))
                        .forEach(System.out::println);
                break;
            case 8:
                datos.stream()
                        .filter(d -> d.genero().equals("Fighting"))
                        .forEach(System.out::println);
                break;
            case 9:
                datos.stream()
                        .filter(d -> d.genero().equals("MOBA"))
                        .forEach(System.out::println);
                break;
            case 10:
                datos.stream()
                        .filter(d -> d.genero().equals("Card Game"))
                        .forEach(System.out::println);
                break;
            case 11:
                datos.stream()
                        .filter(d -> d.genero().equals("Action Game"))
                        .forEach(System.out::println);
                break;
        }
    }
}
