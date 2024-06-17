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

//LUCAS: Si ven las lista_aviones, Lista_Personas y Lista_Vuelos implementan la interfaz Iterator. Al final hay tres funciones sobreescritas
// de esa interfaz. Eso lo hice para que podamos iterar directamente sobre esas listas.

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.inicio();


    }
}