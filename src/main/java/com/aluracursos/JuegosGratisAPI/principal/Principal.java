package com.aluracursos.JuegosGratisAPI.principal;

import com.aluracursos.JuegosGratisAPI.calculos.FiltroGenero;
import com.aluracursos.JuegosGratisAPI.modelo.DatosJuegos;
import com.aluracursos.JuegosGratisAPI.servicio.ConsumoAPI;
import com.aluracursos.JuegosGratisAPI.servicio.ConvertirDatos;
import com.fasterxml.jackson.core.type.TypeReference;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private static final String URL_BASE = "https://www.freetogame.com/api/games";
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConvertirDatos conversor = new ConvertirDatos();
    private final FiltroGenero filtroGenero = new FiltroGenero();
    Scanner escaner = new Scanner(System.in);

    public void muestraMenu(){

        var json = consumoAPI.obtenerDatos(URL_BASE);
        List<DatosJuegos> datos = conversor.obtenerDatos(json, new TypeReference<List<DatosJuegos>>() {});

        System.out.println("Se muestran 5 juegos gratuitos como ejemplo: \n");
        datos.stream()
                .limit(5)
                .forEach(System.out::println);


        //Busqueda de juegos por genero
        System.out.println("\nBusca juegos seleccionando el genero de interes: \n");
        System.out.println("""
				1-  Shooter
				2-  MMORPG
				3-  Strategy
				4-  Action RPG
				5-  Battle Royale
				6-  ARPG
				7-  MMOAPRG
				8-  Fighting
				9-  MOBA
				10- Card Game
				11- Action Game
				""");

        System.out.println("Ingresa la opcion elegida: ");
        var generoElegido = escaner.nextInt();
        escaner.nextLine();
        filtroGenero.FiltrarGenero(datos, generoElegido);


        //Busqueda de juegos por nombre
        System.out.println("\n\nEscriba el nombre del juego gratuito que desea buscar:");
        var nombreJuego = escaner.nextLine();
        Optional<DatosJuegos> juegoBuscado = datos.stream()
                .filter(d -> d.titulo().toUpperCase().contains(nombreJuego.toUpperCase()))
                .findFirst();

        //Verificación de éxito de busqueda por nombre
        if(juegoBuscado.isPresent()){
            System.out.println("Juego encontrado:\n" + "Titulo: " + juegoBuscado.get().titulo() + "\nPequeña descripcion: " + juegoBuscado.get().descripcion() + "\nFecha de lanzamiento: " + juegoBuscado.get().fechaDeLanzamiento());
        } else {
            System.out.println("No se ha encontrado el juego");
        }


        //Busqueda de juegos a partir de fecha de lanzamiento
        System.out.println("\n\nIndique el año a partir del cual mostrar los juegos gratiutos");
        var fecha = escaner.nextInt();
        escaner.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
        datos.stream()
                .filter(d -> d.fechaDeLanzamiento() != null && d.fechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(d -> System.out.println(
                        "Titulo: " + d.titulo() + " / Genero: " + d.genero() + " / Fecha de Lanzamiento: " + d.fechaDeLanzamiento()
                ));


    }

}
