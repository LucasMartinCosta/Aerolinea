import Aviones.Avion;
import Menus.Menu;
import Paquete_personas.Admin;
import Paquete_personas.Cliente;
import Paquete_personas.Genero;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import paquete_archivos.Manejo_archivos;
//import paquete_archivos.Manejo_archivos;

import java.io.IOException;

//ANOTACIONES GENERALES//
//LUCAS: IMPORTANTE; acordarse de que trabajamos con las estructuras que estan instanciadas en Manejo_archivos en la clase menu!!!
//desde esa variable accedemos a todas las listas. Una vez inicializado el programa leemos todos los archivos y se cargan las listas
//cuando terminamos de usar el programa hay que guardar las listas en los archivos y asi no vamos a tener problemas con los datos.

public class Main {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        Manejo_archivos inicArchivos = new Manejo_archivos();

        inicArchivos.prueba();
        inicArchivos.leerarchivo_personas();

        inicArchivos.prueba_aviones();
        //inicArchivos.leer_archivo_aviones();

        inicArchivos.prueba_vuelos();
        inicArchivos.leerarchivo_vuelos();


        menu.inicio(); //Funciona, excepto el salir del menu principal(cerrar el programa)


//            Admin a = new Admin();
//
//            a.crearAvion();
//            a.crearAvion();

    }
}