import Aerolinea.Aerolinea;
import Aviones.Avion;

import Paquete_personas.Cliente;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

//        Avion avion2 = new Avion("prueba", 120, 15, 1, 5);   PRUEBA COMPRA DE ASIENTOS
//        //avion2.mostrarAsientos();
//        avion2.comprarAsiento(1, 'A');
//        avion2.comprarAsiento(3, 'C');
//        avion2.comprarAsiento(5, 'B');
//        avion2.mostrarAsientos();


        Lista_vuelos listavuelos= new Lista_vuelos();

        Cliente cliente1 = new Cliente("Imanol","Sayago", "Imanolsayago0@gmail.com", 123, LocalDate.of(2003,10,10), 12, 418648);



    }
}