package Aerolinea;

import Paquete_personas.Cliente;
import Paquetes_vuelos.Vuelo;

import java.time.LocalDate;
import java.util.*;


public class Reserva {
    private Cliente cliente;
    private ArrayList<Vuelo> vuelos;
    private Integer id;  // la vamos a usar de codigo
    private Double costoTotal;

    private Scanner scan = new Scanner(System.in);

    public Reserva(Cliente cliente) {
        this.id = IDGenerator.generateID() ;
        this.cliente = cliente;
        this.vuelos = new ArrayList<>();
    }

    public void agregaVuelo (Vuelo dato)
    {
        for (Vuelo vuelo:vuelos)
        {
            vuelos.add(dato);
        }
    }


//    //muestra reserva no PASAJE
//    public void mostrarReserva() {
//        try {
//            System.out.println("\n-------------------\n");
//            System.out.println("\nAPELLIDO:");
//            String apellidoCliente = scan.nextLine();
//            System.out.println("\nCODIGO DE RESERVA:");
//            Integer id1 = Integer.parseInt(scan.nextLine());
//
//            if (cliente.getApellido().equalsIgnoreCase(apellidoCliente) && id.equals(id1)) {
//                System.out.println(cliente.getNombre() + " " + cliente.getApellido());
//                for (Vuelo vuelo : vuelos) {
//                    System.out.println(vuelo.mostrarEnReserva());
//                }
//            } else {
//                throw new NoSuchElementException("No tienes ninguna reserva.");
//            }
//        } catch (NoSuchElementException e) {
//            System.out.println(e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("Formato de código de reserva no válido.");
//        }
//    }

    //MUESTRA EL ESTADO DEL VUELO
    public void mostrarEstadoDelVuelo(Integer id1) {
        if (id.equals(id1)) {
            boolean vueloEncontrado = false;
            for (Vuelo vuelo : vuelos) {
                vueloEncontrado = true;
                System.out.println("\nEl estado de su vuelo es: " + vuelo.getCondicionVuelo());
            }
            if (!vueloEncontrado) {
                throw new NoSuchElementException("\nNo se encontró ningún vuelo con el ID proporcionado.");
            }
        } else {
            throw new NoSuchElementException("\nNo se encontró ninguna reserva con el ID proporcionado.");
        }

    }


    //ESTE MUESTRA EL PASAJE UNA VEZ HECHO EL CHECK IN
    public void mostrarPasaje(Integer id1) {

        if (id.equals(id1)) {
            System.out.println(cliente.toString());
            for (Vuelo vuelo : vuelos) {
                System.out.println(vuelo.toString());
            }
        } else {
            throw new NoSuchElementException("No se encontró ninguna reserva con el ID proporcionado.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }
}












