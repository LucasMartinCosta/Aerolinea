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

        Avion avion2 = new Avion("prueba", 120, 15, 1, 5);  // PRUEBA COMPRA DE ASIENTOS
        //avion2.mostrarAsientos();
        avion2.mostrarAsientos();


        Lista_vuelos listavuelos= new Lista_vuelos();

        Cliente cliente1 = new Cliente("Imanol","Sayago", "Imanolsayago0@gmail.com", 123, LocalDate.of(2003,10,10), 12, 418648);

        int opcion1;
        System.out.println("Ingrese 1 si usted desea comprar un pasaje");
        System.out.println("Ingrese 2 si usted desea ver informacion de su vuelo");
        System.out.println("Ingrese 3 si usted desea ...");
        opcion1 = lector.nextInt();
        lector.nextLine();

        switch (opcion1)
        {
            case 1:
                System.out.println("Usted ingreso en el apartado de compra de vuelos");
                System.out.println("Vuelos disponibles: ");
                listavuelos.mostrar_paquetes_vuelos();
        }


    }
}