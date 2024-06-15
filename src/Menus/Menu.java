package Menus;

import Aerolinea.Aerolinea;
import Aerolinea.Reserva;
import Paquete_personas.Cliente;
import Paquete_personas.Empleado;
import Paquete_personas.Genero;
import Paquete_personas.Persona;
import Paquetes_vuelos.Destinos;
import Paquetes_vuelos.Lista_vuelos;
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

    //Probar bien el menu///
    public void inicio() {
        boolean exit = false;
        int eleccion;


        archivos.prueba();
        archivos.leerarchivo_personas();

        while (!exit) {
            System.out.println("\n-----------SKYCODE AIRLINE------------");
            System.out.println("\n1.INICIAR SESION");
            System.out.println("\n2.REGISTRARSE");
            System.out.println("\n3.SALIR");
            System.out.println("\n---------------------------------------");
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

    public void iniciarSesion() //falta agregar que si no te encuentra salte un error y te devuelva al menu principal // ya esta rey
    {
        boolean sesionExitosa = false;

        try {
            System.out.println("Ingrese apellido:");
            String apellido = lector.nextLine();
            System.out.println("Ingrese contraseña:");
            String contra = lector.nextLine();

            Persona persona = archivos.buscarPersona(apellido, contra);

            if (persona != null) {
                sesionExitosa = true;
                if (persona instanceof Cliente) {
                    menuCliente((Cliente) persona);
                } else if (persona instanceof Empleado) {
                    menuEmpleado((Empleado) persona);
                }
            } else {
                System.out.println("La persona no existe dentro del sistema, tendra que registrarla");
                System.out.println("Volviendo al inicio...");
                inicio();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());

        }

    }

    public Cliente registrarCliente() {


        System.out.println("\nIngrese su nombre: ");
        String nombre = lector.nextLine();

        System.out.println("\nIngrese su apellido: ");
        String apellido = lector.nextLine();

        System.out.println("]nIngrese su mail: ");
        String mail = lector.nextLine();

        System.out.println("\nIngrese su contraseña");
        String contra = lector.nextLine();

        //MUESTRA LAS OPCIONES DE GENERO
        //use un bucle para que ingrese ocpiones validas y que vuelva a ingresar si se equivoca


        boolean seleccionValida = false;
         Genero genero= null;
        while (!seleccionValida) {

            System.out.println("\nGenero: ");
            for (Genero genero1 : Genero.values()) {
                System.out.println(genero1.getCodigo() + "." + genero1);
            }
            System.out.println("\nIngrese una opcion: ");

            if (lector.hasNextInt()) {
                int opcion = lector.nextInt();
                lector.nextLine();
                genero = Genero.getByCodigo(opcion);

                if (genero != null) {
                    seleccionValida = true;
                } else {
                    System.out.println("\nGenero no válido. Por favor, seleccione una opcion valida.");
                    lector.nextLine();
                }
            } else {
                System.out.println("\nEntrada inválida. Por favor, ingrese un numero valido.");
                lector.nextLine();
            }
        }


            Cliente persona = new Cliente(nombre, apellido, mail, contra, genero);

            archivos.getListaPersonas().add(persona);

            archivos.cargararchivo_personas();
            return persona;
        }



    public void registrarUsuarioEmpleado() //SOLO DIOS // esta funcion tiene que poder permitirle al dios ingresar
    // todos los datos de un empleado, generarle una contraseña y guardarlo en el treeset de personas.
    {

    }

    public void menuCliente(Cliente cliente) {
        boolean exit = false;
        int opcion1;

        while (!exit) {
            System.out.println("\n-----------------------");
            System.out.println("\n1.COMPRAR PASAJE");
            System.out.println("\n2.ESTADO DE VUELO");
            System.out.println("\n3.VER PASAJE"); // mostramos de a un pasaje
            System.out.println("\n4.VER RESERVAS");
            System.out.println("\n5.DEVOLUCION / CANCELACION DE VUELOS");
            System.out.println("\n6.SALIR DEL MENU");
            System.out.println("\n-----------------------");
            opcion1 = lector.nextInt();
            lector.nextLine();

            switch (opcion1) {
                case 1:

//                    Lista_vuelos auxiliar= archivos.getVuelos();
//                    System.out.println(auxiliar);  teoricamente esto deberia mostrar los vuelos que hay en el archivo pero para
                    //sopresa de nadie no lo muestra

                    //LUCAS: COMPRAR PASAJE tiene que mostrar una lista de todos los vuelos disponibles para poder hacer una compra, el cliente
                    //toca el numero del pasaje que quiere comprar y se añade a su lista

                    Reserva nuevaReserva = new Reserva(cliente); //creo una nueva reserva

                    Vuelo vueloAComprar = cliente.elegirVueloAComprar(archivos.getVuelos()); //el cliente elige que vuelo comprar

                    Double costo = cliente.comprarAsientos(vueloAComprar); //compra los asientos de ese vuelo
                    nuevaReserva.agregaVuelo(vueloAComprar);// se carga ese vuelo a su array de vuelos en la reserva
                    nuevaReserva.setCostoTotal(costo); //cargo el costo a la reserva
                    cliente.agregarReserva(nuevaReserva); //agrego la reserva a la lista de reservas del cliente
                    break;

                case 2:
                    Reserva reserva = new Reserva(cliente); // En cada caso tenes q hacer una nueva reserva
                    System.out.print("Ingrese el ID del vuelo para ver su estado: ");
                    int idVuelo = lector.nextInt();
                    lector.nextLine();
                    reserva.mostrarEstadoDelVuelo(idVuelo);
                    break;
                case 3:

                    break;
                case 4:
                    //cliente
                case 5:
                    //en este caso eliminamos el vuelo ingresndo a traves del scanner luego lo pasamos a reserva.eliminarReserva
                   // System.out.print("Ingrese el ID para eliminar/cancelar su vuelo: ");
//                   Integer idVuelo = lector.nextInt();
//                   reserva.eliminarReserva(idVuelo);
                    break;
                case 6:
                    inicio();
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
            }
        }
        lector.close();
    }

    public void menuEmpleado(Empleado empleado) {

        boolean exit = false;
        int opcion1;
        while (!exit) {
            System.out.println("\n-----------------------");
            System.out.println("\n1.VER UN VUELO");
            System.out.println("\n2.HACER VUELOS NUEVOS");
            System.out.println("\n3.VER LISTA DE AVIONES COMPLETA");
            System.out.println("\n4.VER LISTA DE VUELOS COMPLETA");
            System.out.println("\n5.VER LISTA DE PASAJEROS POR VUELO");
            System.out.println("\n6.MODIFICAR ESTADO DE VUELO");
            System.out.println("\n7.SALIR DEL MENU");
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
                    empleado.mostrarListaAviones();
                    break;
                case 4:
                    empleado.mostrarListaVuelos();
                case 5:
                    System.out.println("\n Ingrese el codigo de vuelo que desea ver: ");
                    Integer codigo2 = lector.nextInt();
                    empleado.verPasajerosXVuelo(codigo2);
                    break;
                case 6:
                    //modificar estado de vuelo.
                    System.out.println("\n Ingrese el codigo de vuelo a buscar: ");
                    Integer codigo3 = lector.nextInt();
                    empleado.modificarEstadoVuelo(codigo3);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
            }
        }
        lector.close();
    }
}









