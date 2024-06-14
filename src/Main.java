import Menus.Menu;
import Paquete_personas.Cliente;
import paquete_archivos.Manejo_archivos;
//import paquete_archivos.Manejo_archivos;

import java.io.IOException;

//ANOTACIONES GENERALES//
//LUCAS: En los archivos solamente vamos a guardar datos Personas, vuelos y aviones

public class Main {
    public static void main(String[] args) throws IOException {

        Cliente cliente2 = new Cliente("Lucas", "Costa", "lucas@", "lucas");

        Menu menu = new Menu();
        Manejo_archivos inicArchivos = new Manejo_archivos();

        inicArchivos.prueba();
        //inicArchivos.leer_todo_archivo_personas();

        inicArchivos.prueba_aviones();
        inicArchivos.leer_archivo_aviones();

        inicArchivos.prueba_vuelos();
        inicArchivos.leerarchivo_vuelos();


        //menu.inicio();
        menu.menuCliente(cliente2);





    }
}