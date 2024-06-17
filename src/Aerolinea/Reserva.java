package Aerolinea;

import Paquete_personas.Cliente;
import Paquetes_vuelos.Vuelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


public class Reserva implements Serializable {
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

    public Reserva() {
    }



    public void agregaVuelo (Vuelo dato)
    {

            vuelos.add(dato);

    }



    //MUESTRA EL ESTADO DEL VUELO
    public void mostrarEstadoDeTodosLosVuelos() {
        if (!vuelos.isEmpty()) {
            for (Vuelo vuelo : vuelos) {
                System.out.println("\nEl estado de su vuelo es: " + vuelo.getCondicionVuelo());
            }
        } else {
            System.out.println("\nNo hay vuelos asociados a esta reserva.");
        }
    }

    //ESTE MUESTRA EL PASAJE
    public String mostrarPasaje() {
        StringBuilder resultado = new StringBuilder();

        if (!vuelos.isEmpty()) {
            for (Vuelo vuelo : vuelos) {
                resultado.append(vuelo.mostrarPasaje()).append("\n");
            }
        } else {
            resultado.append("\nNo hay vuelos asociados a esta reserva.");
        }

        return resultado.toString();
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

    @Override
    public String toString() {
        return
                "\n CLIENTE: " + cliente +
                "\n VUELO: " + vuelos +
                "\n COSTO TOTAL:$" + costoTotal +
                "\n --------- \n";
    }
}












