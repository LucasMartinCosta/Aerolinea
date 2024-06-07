import Aerolinea.Aerolinea;
import Aviones.Avion;

import Menus.Menu;
import Paquete_personas.Cliente;
import Paquete_personas.Persona;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import Tipos_listas.Lista_reservas;
import paquete_archivos.Manejo_archivos;
//import paquete_archivos.Manejo_archivos;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Menu menu = new Menu();
        Manejo_archivos inicArchivos = new Manejo_archivos();

        inicArchivos.prueba();
       inicArchivos.leer_todo_archivo_personas();

       inicArchivos.prueba_aviones();
       inicArchivos.leer_archivo_aviones();

       inicArchivos.prueba_vuelos();
       inicArchivos.leerarchivo_paquetes();

        menu.inicio();






    }
}