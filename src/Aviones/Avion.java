package Aviones;

import Paquete_personas.Cliente;

import java.util.HashMap;
import java.util.Map;

public class Avion  {

    private Map<Integer, Map <Character, Asiento>> asientos;
    private String modelo;
    private Integer capacidad_personas;
    private double tiempo_vuelo; // en horas
    private String tipo;  /*PRIVADO O COMERCIAL*/
    private int estado;    /*Disponi|ble(1) - Ocupado (0) - Reparacion (-1) */

    public Avion() {
    }

    public Avion(String modelo, Integer capacidad_personas, double tiempo_vuelo, int estado, int filas) {
        this.modelo = modelo;
        this.capacidad_personas = capacidad_personas;
        this.tiempo_vuelo = tiempo_vuelo;
        this.estado = estado;

        asientos = new HashMap<>(); // inicializador de filas.

        for (int i=1; i<= filas; i++)
        {
            Map<Character, Asiento> fila = new HashMap<>();
            fila.put('A', new Asiento(i, 'A'));
            fila.put('B', new Asiento(i, 'B'));
            fila.put('C', new Asiento(i, 'C'));
            fila.put('D', new Asiento(i, 'D'));
            fila.put('E', new Asiento(i, 'E'));
            fila.put('F', new Asiento(i, 'F'));
            asientos.put(i, fila);
        }
    }


    @Override
    public String toString() {
        return "Avion{" +
                "asientos=" + asientos +
                ", modelo='" + modelo + '\'' +
                ", capacidad_personas=" + capacidad_personas +
                ", tiempo_vuelo=" + tiempo_vuelo +
                ", tipo='" + tipo + '\'' +
                ", estado=" + estado +
                '}';
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad_personas() {
        return capacidad_personas;
    }

    public void setCapacidad_personas(Integer capacidad_personas) {
        this.capacidad_personas = capacidad_personas;
    }

    public double getTiempo_vuelo() {
        return tiempo_vuelo;
    }

    public void setTiempo_vuelo(double tiempo_vuelo) {
        this.tiempo_vuelo = tiempo_vuelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public boolean comprarAsiento (Cliente dato, int fila, char letra)
    {
        if (asientos.containsKey(fila) && asientos.get(fila).containsKey(letra))
        {
            Asiento aux = asientos.get(fila).get(letra);
            if(!aux.isDisponible())
            {
                aux.reservar(dato);
                return true;
            }
            else
            {
                System.out.println("El asiento ya está reservado.");
                return false;
            }
        }
        else {
            System.out.println("El asiento no existe.");
            return false;
        }
    }

    public boolean liberarAsiento (int fila, char letra)
    {
        if(asientos.containsKey(fila)&& asientos.get(fila).containsKey(letra))
        {
            Asiento aux = asientos.get(fila).get(letra);
            if(aux.isDisponible())
            {
                aux.liberar();
                return true;
            } else {
                System.out.println("El asiento no está reservado.");
                return false;
            }
        } else {
            System.out.println("El asiento no existe.");
            return false;
        }
    }

    public void mostrarAsientos() {
        for (Map.Entry<Integer, Map<Character, Asiento>> filaEntry : asientos.entrySet()) {
            int fila = filaEntry.getKey();
            System.out.print("Fila " + fila + ": ");
            for (Map.Entry<Character, Asiento> asientoEntry : filaEntry.getValue().entrySet()) {
                Asiento asiento = asientoEntry.getValue();
                System.out.print(asiento.getLetra() + (asiento.isDisponible() ? "(R) " : "(D) "));
            }
            System.out.println();
        }
    }



}
