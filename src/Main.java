import Aviones.Avion;
import Menus.Menu;
import Paquete_personas.Cliente;
import Paquete_personas.Genero;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import paquete_archivos.Manejo_archivos;
//import paquete_archivos.Manejo_archivos;

import java.io.IOException;

//ANOTACIONES GENERALES//
//LUCAS: En los archivos solamente vamos a guardar datos Personas, vuelos y aviones

public class Main {
    public static void main(String[] args) throws IOException {

        Cliente cliente2 = new Cliente("Lucas", "Costa", "lucas@", "lucas", Genero.MASCULINO);

        Menu menu = new Menu();
        Manejo_archivos inicArchivos = new Manejo_archivos();

   inicArchivos.prueba();
  inicArchivos.leerarchivo_personas();

        inicArchivos.prueba_aviones();
        inicArchivos.leer_archivo_aviones();

        inicArchivos.prueba_vuelos();
        inicArchivos.leerarchivo_vuelos();


        menu.inicio(); //NO FUNCIONA - CICLO INFINITO - ARREGLAR



        menu.menuCliente(cliente2);





    }
}