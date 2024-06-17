package Aerolinea;

import Paquete_personas.Cliente;
import Paquetes_vuelos.Vuelo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;



public class Reserva implements Serializable {
    @JsonBackReference
    private Cliente cliente;
    private ArrayList<Vuelo> vuelos;
    private Integer id;  // la vamos a usar de codigo
    private Double costoTotal;
    private int fila;
    private Character letra;
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
    public void mostrarPasaje() {
        if (!vuelos.isEmpty()) {
            for (Vuelo vuelo : vuelos) {
                System.out.println(vuelo.mostrarPasaje());
            }
        }else {
            System.out.println("\nNo hay vuelos asociados a esta reserva.");
        }

    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Character getLetra() {
        return letra;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
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
        return  "\n RESERVA NUMERO: " + id +
                "\n FILA: " + fila +
                "\n ASIENTO: " + letra +
                "\n CLIENTE: " + cliente +
                "\n VUELO: " + vuelos +
                "\n COSTO TOTAL: " + costoTotal +
                "\n --- \n";
    }
}












