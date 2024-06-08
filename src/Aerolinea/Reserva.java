package Aerolinea;

import Paquete_personas.Cliente;
import Paquetes_vuelos.Vuelo;

import java.time.LocalDate;
import java.util.*;


public class Reserva {

    private String asiento;
    private Cliente cliente;
    private ArrayList<Vuelo> vuelos;
    private Integer id;  // la vamos a usar de codigo
    private Double costoTotal;
    private Scanner scan = new Scanner(System.in);

    public Reserva(Integer id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.vuelos = new ArrayList<>();
    }

//    //muestra reserva no PASAJE
//    public void mostrarReserva() {
//        String apellidoCliente=null;
//        Integer id1;
//
//        System.out.println("\n-------------------\n");
//        System.out.println("\nAPELLIDO:");
//        apellidoCliente = scan.nextLine();
//        System.out.println("\nCODIGO DE RESERVA:");
//        id1 = Integer.parseInt(scan.nextLine());
//
//        if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id==id1){
//
//            System.out.println(""+cliente.getNombre() + " "+ cliente.getApellido());
//            for (Vuelo vuelo: vuelos) {
//                System.out.println("" + vuelo.mostrarEnReserva());
//            }
//
//
//        }else {
//            System.out.println("\nNo tenes ninguna reserva");
//        }
//
//    }

    public void mostrarEstadoDelVuelo(Integer id1) {
        try {
            if (id == id1) {

                for (Vuelo vuelo : vuelos) {


                    System.out.println("\nEl estado de su vuelo es=:  " + vuelo.getCondicionVuelo());
                }

            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());
        }

    }


//  public void modificarReserva(Cliente dato){
////
//////tiene que recibir el apellido del cliente, el id de la reserva, verificar que exista y modificar los datos del vuelo con los setters
////
////        String apellidoCliente=null;
////        Integer id1;
////        int opcion=0;
////
////
////
////        System.out.println("\n-------------------\n");
////        System.out.println("\nAPELLIDO:");
////        apellidoCliente = scan.nextLine();
////        System.out.println("\nCODIGO DE RESERVA:");
////        id1 = Integer.parseInt(scan.nextLine());
////
////
////        if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id==id1){
////            System.out.println("\n1.MODIFICAR FECHA DE SALIDA= ");
////            System.out.println("\n2.MODIFICAR FECHA DE LLEGADA= ");
////            System.out.println("\n3.ELIJA UNA OPCION= ");
////            opcion = scan.nextInt();
////            switch (opcion) {
////                case 1:
////                    System.out.println("\nIngrese la nueva fecha de salida (YYYY-MM-DD):");
////                    String nuevaFechaSalidaStr = scan.next();
////                    LocalDate nuevaFechaSalida = LocalDate.parse(nuevaFechaSalidaStr);
////                    for (Vuelo vuelo: vuelos) {
////
////                        vuelo.setFechaSalida(nuevaFechaSalida);
////                    }
////                    break;
////                case 2:
////                    System.out.println("\nIngrese la nueva fecha de llegada (YYYY-MM-DD):");
////                    String nuevaFechaLlegadastr = scan.next();
////                    LocalDate nuevaFechaLlegada = LocalDate.parse(nuevaFechaLlegadastr);
////                    for (Vuelo vuelo: vuelos) {
////
////                        vuelo.setFechaLlegada(nuevaFechaLlegada); }
////
////                    break;
////
////            default:
////                System.out.println("\nOPCION NO VALIDA");}
////            } else {
////            System.out.println("\nEl cliente no tiene reservas.");
////            }
////           }


    //ESTE MUESTRA EL PASAJE UNA VEZ HECHO EL CHECK IN
    public void mostrarPasaje(Integer id1) {

        try {
            if (id == id1) {

                System.out.println("" + cliente.toString());
                System.out.println("" + vuelos.toString());


            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage());

        }
    }

}






    //public int costoFinal() // funcion para calcular el costo final del pasaje










