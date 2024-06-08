package Menus;

import Aerolinea.Aerolinea;
import Aerolinea.Reserva;
import Paquete_personas.Cliente;
import Paquete_personas.Empleado;
import Paquete_personas.Persona;
import Paquetes_vuelos.Vuelo;
import paquete_archivos.Manejo_archivos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {

    Manejo_archivos archivos = new Manejo_archivos();
    private Scanner lector = new Scanner(System.in);


//    public void iniciarSesion(){
//
//        Console console =System.console();
//        System.out.println("\n--SKYCODING AIRLINE--");
//        System.out.println("Email: ");
//        if (console == null) {
//            System.out.println("\nNo se puede obtener la consola.");
//            return;
//        }
//        char[] passwordArray = console.readPassword("\nContrasenia: ");
//        String password = new String(passwordArray);
//    }

    public void inicio ()
    {
        boolean exit= false;
        int eleccion;

//        archivos.leer_todo_archivo_personas();
//        archivos.prueba();

        while (!exit) {
            System.out.println("\n-----------AEROLINEAS UTN------------");
            System.out.println("\n1.INICIAR SESION");
            System.out.println("\n2.REGISTRARSE");
            System.out.println("\n3.SALIR");
            System.out.println("\n-----------------------");
            eleccion = lector.nextInt();
            lector.nextLine();

            switch (eleccion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    Cliente cliente1 = registrarCliente(); //aca accede siempre un cliente.
                    menuCliente(cliente1);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
            }
        }
        lector.close();
    }

    public void iniciarSesion () //falta agregar que si no te encuentra salte un error y te devuelva al menu principal
    {
        boolean sesionExitosa = false;
        do {

            try {
                System.out.println("Ingrese apellido:");
                String apellido = lector.nextLine();
                System.out.println("Ingrese contraseña:");
                String contra = lector.nextLine();

                Persona persona = archivos.buscarPersona(apellido, contra);

                if (persona != null) {
                    if (persona instanceof Cliente) {
                        menuCliente((Cliente) persona);
                    } else if (persona instanceof Empleado) {

                        menuEmpleado((Empleado) persona);
                    }

                }
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException(e.getMessage());

            }
        }while (!sesionExitosa);

    }

    public Cliente registrarCliente()
    {
        System.out.println("Ingrese su nombre: ");
        String nombre = lector.nextLine();

        System.out.println("Ingrese su apellido: ");
        String apellido = lector.nextLine();

        System.out.println("Ingrese su mail: ");
        String mail = lector.nextLine();

        System.out.println("ingrese su contraseña");
        String contra = lector.nextLine();

        Cliente persona = new Cliente(nombre, apellido, mail, contra);

        archivos.getListaPersonas().add(persona);

        archivos.cargararchivo_personas();
        return persona;
    }


    public void registrarUsuarioEmpleado() //SOLO DIOS // esta funcion tiene que poder permitirle al dios ingresar
    // todos los datos de un empleado, generarle una contraseña y guardarlo en el treeset de personas.
    {

    }

    public void menuCliente(Cliente cliente) {
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
                    //Mostrar todas las reservas que tiene el cliente, hacerlo elegir una reserva y esa es la que hay que modificar.


                    break;
                case 3:
                    //reserva.mostrarReserva();
                    break;
                case 4:
                    //reserva.mostrarEstadoDelVuelo();
                case 5:
                    //reserva.mostrarPasaje();
                    break;
                case 6:

                    break;
                case 7:
                    cliente.eliminarReserva();
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

    public void menuEmpleado(Empleado empleado) {

        boolean exit= false;
        int opcion1;
        while (!exit) {
            System.out.println("\n-----------------------");
            System.out.println("\n1.VER UN VUELO");
            System.out.println("\n2.HACER VUELOS NUEVOS");
            System.out.println("\n3.VER LISTA DE AVIONES COMPLETA");
            System.out.println("\n4.VER LISTA DE VUELOS COMPLETA");
            System.out.println("\n5.MODIFICAR ESTADO DE VUELO");
            System.out.println("\n8.SALIR DEL MENU");
            System.out.println("\n-----------------------");
            opcion1 = lector.nextInt();
            lector.nextLine();

            switch (opcion1) {
                case 1:
                    //llama a una funcion que pasandole el numero de vuelo te muestre un vuelo en especifico,
                    //con la lista de pasajeros y toda la info
                    System.out.println("\n Ingrese el codigo de vuelo a buscar: ");
                    Integer codigo1 = lector.nextInt();
                    Vuelo aux = empleado.buscarVuelo(codigo1);
                    //Falta el metodo de vuelo de mostrar todos los datos del vuelo.
                    //System.out.println(aux.toString());

                    break;
                case 2:
                    //llama a una funcion que crea vuelos, juntando un avion(que tiene que estar disponible) un origen, y un destino
                    break;
                case 3:
                    //mostrar todos los aviones cargados en el sistema
                    break;
                case 4:
                    //mostrar todos los vuelos cargados en el sistema
                case 5:
                    //modificar estado de vuelo.
                    System.out.println("\n Ingrese el codigo de vuelo a buscar: ");
                    Integer codigo2 = lector.nextInt();
                    empleado.modificarEstadoVuelo(codigo2);
                    break;
                case 6:
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
