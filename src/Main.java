import Aerolinea.Aerolinea;
import Aviones.Avion;

import Menus.Menu;
import Paquete_personas.Cliente;
import Paquete_personas.Persona;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
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

        menu.inicio();



//        Manejo_archivos manejoarchi = new Manejo_archivos();

//
//        TreeSet<Persona> personas = new TreeSet<>();
//        manejoarchi.cargararchivo_personas(personas);
//
//        TreeSet<Persona> personasleidas = new TreeSet<>();
//        Cliente c1 = new Cliente("Juan", "Perez","juanperez@gmail.com");
//        Cliente c2 = new Cliente("Ana", "Gomez", "anitagomexz@gmail.com");
//        Cliente c3 = new Cliente("ramon", "oscar", "ramoncapo@gmail.com");
//        Cliente c4 = new Cliente("pedruito", "caca", "ramoncapo@gmail.com");
//        personas.add(c1);
//        personas.add(c2);
//        personas.add(c3);
//        personas.add(c4);

//        for(Persona personita: personas)
//        {
//            System.out.println(personita.toString());
//        }

//         manejoarchi.cargararchivo_personas(personas);
//         manejoarchi.leer_todo_archivo_personas();
//         manejoarchi.mostrararchivopersonas();

//        ArrayList<Avion>lsta_aviones = new ArrayList<>();
//
//        Avion a1 = new Avion("a1",123,2.4, 1,1);
//        Avion a2 = new Avion("b1",200,3.4, 1,1);
//        Avion a3 = new Avion("c1",250,4.4, 1,1);
//
//        lsta_aviones.add(a1);
//        lsta_aviones.add(a2);
//        lsta_aviones.add(a3);
//
//        for(Avion av: lsta_aviones)
//        {
//            System.out.println(av);
//        }
//
//      manejoarchi.cargaarchivo_aviones(lsta_aviones);
//      manejoarchi.leer_archivo_aviones();
//
//
//      manejoarchi.mostrararchivoAviones();

//        System.out.println("\n");
//        System.out.println("Mostrando archivo");

//        Menu menu = new Menu();
//        menu.menuCliente();



    }
}