package Aerolinea;

import Paquete_personas.Cliente;
import Paquetes_vuelos.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//creo que tendria que llamarse gestionUsuario
//capaz en vez de ingresar apellido y id cada vez que queres hacer algo hay que ver si podes acceder directamente
//o hacerlo de una frorma q el cliente no tenga que poner
//siempre su id y apellido? hhhhh


public class Reserva {

    private String asiento;
    private Cliente cliente;
    private ArrayList<Vuelo> vuelos;
    private Integer id;  // la vamos a usar de codigo
    private Double costoTotal;

    public Reserva(Integer id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.vuelos = new ArrayList<>();
    }

    //muestra reserva no PASAJE
    public void mostrarReserva(String apellidoCliente, Integer id1) {
        if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id==id1){

            System.out.println(""+cliente.getNombre() + " "+ cliente.getApellido());
            for (Vuelo vuelo: vuelos) {
                System.out.println("" + vuelo.mostrarEnReserva());
            }


        }else {
            System.out.println("\nNo tenes ninguna reserva");
        }

    }

    public void mostrarEstadoDelVuelo(String apellidoCliente, Integer id1){

        if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id==id1){

            for (Vuelo vuelo:vuelos){



            System.out.println("\nEl estado de su vuelo es= "+ vuelo.getCondicionVuelo());}

        }else {
            System.out.println("\nNo tenes ninguna reserva");
        }

    }


    public void modificarReserva(String apellidoCliente, Integer id1){
        int opcion=0;
        Scanner scan = new Scanner(System.in);
        if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id==id1){
            System.out.println("\n1.MODIFICAR FECHA DE SALIDA= ");
            System.out.println("\n2.MODIFICAR FECHA DE LLEGADA= ");
            System.out.println("\nELIJA UNA OPCION= ");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la nueva fecha de salida (YYYY-MM-DD):");
                    String nuevaFechaSalidaStr = scan.next();
                    LocalDate nuevaFechaSalida = LocalDate.parse(nuevaFechaSalidaStr);
                    for (Vuelo vuelo: vuelos) {

                        vuelo.setFechaSalida(nuevaFechaSalida);
                    }
                    break;
                case 2:
                    System.out.println("\nIngrese la nueva fecha de llegada (YYYY-MM-DD):");
                    String nuevaFechaLlegadastr = scan.next();
                    LocalDate nuevaFechaLlegada = LocalDate.parse(nuevaFechaLlegadastr);
                    for (Vuelo vuelo: vuelos) {

                        vuelo.setFechaLlegada(nuevaFechaLlegada); }

                    break;

            default:
                System.out.println("\nOPCION NO VALIDA");}
            } else {
            System.out.println("\nEl cliente no tiene reservas.");
            }
           }



           //ESTE MUESTRA EL PASAJE UNA VEZ HECHO EL CHECK IN
    public void mostrarPasaje(String apellidoCliente, Integer id1){
        if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id==id1){

            System.out.println(""+ cliente.toString());
            System.out.println(""+vuelos.toString());


        }else {
            System.out.println("\nNo tenes ningun pasaje pendiente");
        }

    }

    public void eliminarReserva(String apellidoCliente, Integer id1){
        if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id==id1){
            //funcion para eliminar una reserva ni idea como hacer
        }
    }

    public void comprarEquipaje(){


    }

    //public int costoFinal() // funcion para calcular el costo final del pasaje





        }






