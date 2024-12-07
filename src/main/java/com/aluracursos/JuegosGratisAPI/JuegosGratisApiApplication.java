package com.aluracursos.JuegosGratisAPI;

import com.aluracursos.JuegosGratisAPI.calculos.FiltroGenero;
import com.aluracursos.JuegosGratisAPI.modelo.DatosJuegos;
import com.aluracursos.JuegosGratisAPI.principal.Principal;
import com.aluracursos.JuegosGratisAPI.servicio.ConsumoAPI;
import com.aluracursos.JuegosGratisAPI.servicio.ConvertirDatos;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class JuegosGratisApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JuegosGratisApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraMenu();


	}
}
