package Aviones;

import Paquete_personas.Cliente;
import Paquete_personas.Genero;

import java.io.Serializable;

public class Asiento implements Serializable {
    private int fila;
    private char letra;
    private boolean reservado;
    private Cliente cliente;


    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asiento(int fila, char letra) {
        this.fila = fila;
        this.letra = letra;
        reservado = false;
        cliente = new Cliente("","", "", "", Genero.FEMENINO);
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isDisponible() {
        return reservado;
    }

    public void setDisponible(boolean disponible) {
        this.reservado = disponible;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void reservar (Cliente dato)
    {
        this.cliente=dato;
        this.reservado=true;
    }

    public void liberar ()
    {
        this.reservado=false;
        cliente=new Cliente("", "", "", "",Genero.MASCULINO); // pisa el cliente con un constructor vacio
    }

    public Asiento() {
    }

    @Override
    public String toString() {
        //Si es false corta el toString
        if(!this.isReservado()){
            return  "\n UBICACION: " + fila + letra +
                    "\n DISPONIBILIDAD: " + reservado +
                    "\n (true = ocupado - false = disponible " +
                    "\n ---\n";
        }else{ //Si es True muestra el asiento junto al cliente.
            return  "\n UBICACION: " + fila + letra +
                    "\n DISPONIBILIDAD: " + reservado +
                    "\n (true = ocupado - false = disponible " +
                    "\n CLIENTE :" + cliente +
                    "\n --- \n";
        }

    }
}
