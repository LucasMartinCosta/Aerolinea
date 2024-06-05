package Menus;

import Aerolinea.Aerolinea;
import Aerolinea.Reserva;
import Paquete_personas.Cliente;
import Paquete_personas.Empleado;
import Paquetes_vuelos.Vuelo;

import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    private Reserva reserva;
    private Cliente cliente;
    private Empleado empleado;
    private Scanner lector;
    private Aerolinea vuelos;



    public Menu() {
        this.reserva = reserva;
        this.cliente = cliente;
        this.empleado = empleado;
        this.lector = new Scanner(System.in);
        this.vuelos = vuelos;


    }

    public void iniciarSesion(){

        Console console =System.console();
        System.out.println("\n--SKYCODING AIRLINE--");
        System.out.println("Email: ");
        if (console == null) {
            System.out.println("\nNo se puede obtener la consola.");
            return;
        }
        char[] passwordArray = console.readPassword("\nContrasenia: ");
        String password = new String(passwordArray);

    }


    public void menuCliente() {



        boolean exit= false;
        int opcion1;
        while (!exit) {
            System.out.println("\n-----------------------");
            System.out.println("\n1.COMPRAR PASAJE");
            System.out.println("\n2.MODIFICAR MI RESERVA");
            System.out.println("\n3.MOSTRAR MI RESERVA");
            System.out.println("\n4.ESTADO DE VUELO");
            System.out.println("\n5.VER PASAJES DISPONIBLES");
            System.out.println("\n6.COMPRAR EQUIPAJE");
            System.out.println("\n7.DEVOLUCION/ CANCELACION DE VUELOS");
            System.out.println("\n8.SALIR DEL MENU");
            System.out.println("\n-----------------------");
            opcion1 = lector.nextInt();
            lector.nextLine();

            switch (opcion1) {
                case 1:
                    menuCompraPasaje();
                    break;

                case 2:
                   reserva.modificarReserva();

                    break;
                case 3:
                    reserva.mostrarReserva();
                    break;
                case 4:
                    reserva.mostrarEstadoDelVuelo();
                case 5:
                    reserva.mostrarPasaje();

                    break;
                case 6:
                    reserva.comprarEquipaje();
                    break;
                case 7:
                    break;
                case 8:

                exit = true;
                break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
            }
        }

       lector.close();


        }


    public void menuCompraPasaje(){

        System.out.print("\nORIGEN: ");
        String lugarSalida = lector.nextLine();

        System.out.print("   DESTINO: ");
        String lugarLlegada =lector.nextLine();

        System.out.print("\nFECHA  (yyyy-MM-dd): ");
        String fechaStr = lector.nextLine();
        LocalDate fechaIda = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);



        System.out.print("Ingrese el número de pasajeros: ");
        int numeroPasajeros = lector.nextInt();
        lector.nextLine();

        System.out.println("\n-----------------------");

        Vuelo vuelo = new Vuelo(lugarSalida, lugarLlegada, fechaIda,  numeroPasajeros);

        //mostrarPasajesDisponiblesCompra(vuelo);

        System.out.println("\nPasaje comprado exitosamente: " + vuelo);

        System.out.println("\nDesea ver mas pasajes?");
        int opcion=0;
        switch (opcion){

            case 1:
                menuCompraPasaje();

        }




    }

//    public Vuelo mostrarPasajesDisponiblesCompra(Vuelo vuelo){
//
//
//
//
//    }
//
//    public boolean encontrarVuelo(Vuelo vuelo){
//        boolean flag= false;
//        for (Vuelo vuelo1: vuelos)
//            flag= true;
//        }
//
//    }




}
