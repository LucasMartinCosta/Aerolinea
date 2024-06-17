package Menus;

import Aerolinea.Aerolinea;
import Aerolinea.Reserva;
import Paquete_personas.*;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import paquete_archivos.Manejo_archivos;

import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {

    Manejo_archivos archivos = new Manejo_archivos();
    private Scanner lector = new Scanner(System.in);

    //Probar bien el menu///
    public void inicio ()
    {
        boolean exit= false;
        int eleccion;


        archivos.prueba();
        archivos.leerarchivo_personas();
        archivos.leer_archivo_aviones();
        archivos.leerarchivo_vuelos();

        while (!exit) {
            System.out.println("\n-----------AEROLINEAS UTN------------");
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
                    Cliente cliente1 = registrarCliente(); //aca accede siempre un cliente. Los empleados son siempre creados por el admin
                    menuCliente(cliente1);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
            }
        }
        //lector.close();
    }

    public void iniciarSesion ()
    {
        boolean sesionExitosa = false;

            System.out.println("Ingrese apellido:");
            String apellido = lector.nextLine();
            System.out.println("Ingrese contraseña:");
            String contra = lector.nextLine();

            Persona persona = archivos.getLista_personas().buscarPersona(apellido, contra);

            if (persona != null) {
                sesionExitosa=true;
                if (persona instanceof Cliente) {
                    menuCliente((Cliente) persona);
                } else if (persona instanceof Admin) {
                    menuAdmin((Admin) persona);
                } else if (persona instanceof Empleado) {
                    menuEmpleado((Empleado) persona);
                }
            }
            else
            {
                System.out.println("La persona no existe dentro del sistema, tendra que registrarla");
                System.out.println("Volviendo al inicio...");
                inicio();
            }

    }





    //en registrar cliente hay que hacer un return de que?
    // LUCAS: hace el return de la persona que se registra para dsp poder pasarla al menu

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
        Genero genero = null;
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
        Cliente persona = new Cliente(nombre, apellido, mail, contra, Genero.MASCULINO);

        archivos.getLista_personas().agregar_personas(persona);
        //archivos.cargararchivo_personas(); //LUCAS: No hay que cargar el archivo en todas las funciones, en las funciones  solamente trabajamos
        //con la estructura y al final lo que cargamos al archivo es la estructura cargada
        return persona;
    }


    public void menuCliente(Cliente cliente) {
        boolean exit = false;
        int opcion1;
        Scanner scanCliente = new Scanner(System.in);

        while (!exit) {

            System.out.println("\n-----------MENU CLIENTE------------");
            System.out.println("\n1.COMPRAR PASAJE");
            System.out.println("\n2.ESTADO DE VUELO");
            System.out.println("\n3.VER PASAJE"); // mostramos de a un pasaje
            System.out.println("\n4.VER RESERVAS");
            System.out.println("\n5.DEVOLUCION / CANCELACION DE VUELOS");
            System.out.println("\n6.SALIR DEL MENU");
            System.out.println("\n-----------------------");

            opcion1 = scanCliente.nextInt();
            scanCliente.nextLine(); // consume the newline

                switch (opcion1) {
                case 1:
                    //LUCAS: COMPRAR PASAJE tiene que mostrar una lista de todos los vuelos disponibles para poder hacer una compra, el cliente
                    //toca el numero del pasaje que quiere comprar y se añade a su lista
                    if(cliente.getEdad()==0)
                    {
                        System.out.println("Ingrese su edad: ");
                        cliente.setEdad(scanCliente.nextInt());
                        scanCliente.nextLine();
                    }
                    if(cliente.getNumTelefono()==0)
                    {
                        System.out.println("Ingrese su numero de telefono: ");
                        cliente.setNumTelefono(scanCliente.nextLong());
                        scanCliente.nextLine();
                    }
                    if (cliente.getPasaporte()==null)
                    {
                        System.out.println("Ingrese el numero de su pasaporte");
                        cliente.setPasaporte(scanCliente.nextInt());
                        scanCliente.nextLine();
                    }

                    Reserva nuevaReserva = new Reserva(cliente); //creo una nueva reserva
                    Vuelo vueloAComprar = cliente.elegirVueloAComprar(archivos.getVuelos()); //el cliente elige que vuelo comprar
//
                    Double costo = cliente.comprarAsientos(vueloAComprar, nuevaReserva); //compra los asientos de ese vuelo
                    nuevaReserva.agregaVuelo(vueloAComprar);// se carga ese vuelo a su array de vuelos en la reserva
                    nuevaReserva.setCostoTotal(costo); //cargo el costo a la reserva
                    cliente.agregarReserva(nuevaReserva); //agrego la reserva a la lista de reservas del cliente
                    cliente.mostrarReservas();


                    break;

                case 2:
                    //mostras reserva
                    cliente.mostrarReservas();
                    //pide que ingreses el id de la reserva
                    System.out.print("Ingrese el ID de la reserva para ver el estado su estado: ");
                    //este ciclo hace que cuando ingresas un caracter no valido vuelva a pedirte que lo ingreses
                    while (!scanCliente.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número:");
                        scanCliente.next(); // Limpiar el buffer de entrada
                    }

                    int idVuelo = scanCliente.nextInt();
                    //accede a el estado de el/los vuelos que tengas y su estado en esa reserva
                    cliente.mostrarEstadoDelVuelo(idVuelo);
                    break;
                case 3:
                    //MOSTRAMOS PASAJES DEL CLIENTE
                    cliente.mostrarPasajes();
                    break;

                case 4:
                    //mostramos reserva del cliente
                    cliente.mostrarReservas();
                    break;
                case 5:
                    //en este caso eliminamos el vuelo ingresndo a traves del scanner luego lo pasamos a reserva.eliminarReserva
                     System.out.print("Ingrese el ID para eliminar/cancelar su reserva: ");
                     Integer eleccion = lector.nextInt();
                   cliente.eliminarReserva(eleccion);
                    break;
                case 6:
                    archivos.cargararchivo_personas();
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
                }
        }

    }

    public void menuEmpleado(Empleado empleado) {

        boolean exit= false;
        int opcion1;
        while (!exit) {
            System.out.println("\n------------MENU EMPLEADO-----------");
            System.out.println("\n1.VER UN VUELO");
            System.out.println("\n2.HACER VUELOS NUEVOS");
            System.out.println("\n3.VER LISTA DE AVIONES COMPLETA");
            System.out.println("\n4.VER LISTA COMPLETA DE CLIENTES");
            System.out.println("\n5.VER LISTA DE VUELOS COMPLETA");
            System.out.println("\n6.VER LISTA DE PASAJEROS POR VUELO");
            System.out.println("\n7.MODIFICAR ESTADO DE VUELO");
            System.out.println("\n8.SALIR DEL MENU");
            System.out.println("\n-----------------------");
            opcion1 = lector.nextInt();
            lector.nextLine();

            switch (opcion1) {
                case 1:
                    //llama a una funcion que pasandole el numero de vuelo te muestre un vuelo en especifico,
                    //con la lista de pasajeros y toda la info
                    System.out.println("\n Ingrese el codigo de vuelo a buscar: ");
                    String codigo1 = lector.nextLine();
                    Vuelo aux = empleado.buscarVuelo(codigo1, archivos);
                    //Falta el metodo de vuelo de mostrar todos los datos del vuelo.
                    //System.out.println(aux.toString());

                    break;
                case 2:
                    //crea vuelos nuevos y lo muestra.
                    Vuelo creado=empleado.crearVuelo(archivos);
                    System.out.println("Vuelo creado con exito: " + creado.toString());
                    break;
                case 3:
                    empleado.mostrarListaAviones(archivos);
                    break;
                case 4:
                    //Muestra solo los clientes de la lista Personas.
                    empleado.mostrarListaClientes(archivos);
                case 5:
                    empleado.mostrarListaVuelos(archivos);
                    break;
                case 6:
                    System.out.println("\n Ingrese el codigo de vuelo que desea ver: ");
                    String codigo2 = lector.nextLine();
                    empleado.verPasajerosXVuelo(codigo2, archivos);
                    break;
                case 7:
                    //modificar estado de vuelo.
                    System.out.println("\n Ingrese el codigo de vuelo a buscar: ");
                    String codigo3 = lector.nextLine();
                    empleado.modificarEstadoVuelo(codigo3, archivos);
                    break;
                case 8:
                    archivos.cargararchivo_personas();
                    archivos.cargaarchivo_aviones();
                    archivos.cargararchivo_vuelos();
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
            }
        }


    }

    public void menuAdmin(Admin admin) {


        boolean exit= false;
        int opcion1;
        while (!exit) {
            System.out.println("\n----------MENU ADMINISTRADOR-------------");
            System.out.println("\n1.CREAR UN AVION");
            System.out.println("\n2.CREAR USER DE EMPLEADO");
            System.out.println("\n3.VER LISTA DE AVIONES COMPLETA");
            System.out.println("\n4.VER LISTA DE VUELOS COMPLETA");
            System.out.println("\n5.VER LISTA EMPLEADOS COMPLETA");
            System.out.println("\n6.VER LISTA DE PASAJEROS POR VUELO");
            System.out.println("\n7.MODIFICAR ESTADO DE VUELO");
            System.out.println("\n8.DESPEDIR EMPLEADO:");
            System.out.println("\n9.ELIMINAR UN AVION DEL SISTEMA");
            System.out.println("\n10.SALIR DEL MENU");
            System.out.println("\n-----------------------");
            opcion1 = lector.nextInt();
            lector.nextLine();

            switch (opcion1) {
                case 1:
                    admin.crearAvion(archivos);
                    break;
                case 2:
                    admin.crearEmpleado(archivos);
                    break;
                case 3:
                    admin.mostrarListaAviones(archivos);
                    break;
                case 4:
                    admin.mostrarListaVuelos(archivos);
                    break;
                case 5:
                    admin.verempleados(archivos);
                    break;
                case 6:
                    //System.out.println("\n Ingrese el codigo de vuelo que desea ver: ");
                    // Integer codigo2 = lector.nextInt();
                    //empleado.verPasajerosXVuelo(codigo2);
                    break;
                case 7:
                    //modificar estado de vuelo.
                    //System.out.println("\n Ingrese el codigo de vuelo a buscar: ");
                    //Integer codigo3 = lector.nextInt();
                    //empleado.modificarEstadoVuelo(codigo3);
                    break;
                case 8:
                    String emailbuscar,contrabuscar;
                    System.out.println("Ingrese el Email del empleado a despedir");
                    emailbuscar=lector.nextLine();
                    System.out.println("Ingrese la contraseña del empleado a despedir");
                    contrabuscar=lector.nextLine();
                    admin.despedirEmpleado(emailbuscar,contrabuscar,archivos.getLista_personas());
                    break;

                case 9:
                    String modeloeliminar;
                    System.out.println("Ingrese el modelo de avion que desea eliminar");
                    modeloeliminar=lector.nextLine();
                            admin.eliminarAvion(modeloeliminar,archivos.getLista_aviones());
                            break;
                case 10:
                    archivos.cargaarchivo_aviones();
                    archivos.cargararchivo_personas();
                    exit = true;
                    break;
                default:
                    System.out.println("\nOpción no valida. Por favor, intente de nuevo.");
            }
        }

    }

    public void mostrarlistavuelos(HashSet<Vuelo> lista)
    {
        for(Vuelo aux: lista)
        {
            System.out.println(aux.toString());
        }
    }
}


