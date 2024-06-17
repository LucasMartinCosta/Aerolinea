package Aviones;

import Paquete_personas.Cliente;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Avion implements Serializable {

    //Manu: Habria que agregar un campo tipo ID o para eso es el modelo?
    private Map<Integer, Map <Character, Asiento>> asientos;
    private String modelo;
    private Integer capacidad_personas;
    private double tiempo_vuelo; // en horas
    private String tipo;  /*PRIVADO O COMERCIAL*/
    private int estado;    /*Disponi|ble(1) - Ocupado (0) - Reparacion (-1) */
    private int filas;

    public Avion() {
    }

    public void setAsientos(Map<Integer, Map<Character, Asiento>> asientos) {
        this.asientos = asientos;
    }


    public Avion(String modelo, double tiempo_vuelo, int estado, int filas) {
        this.modelo = modelo;
        this.capacidad_personas = inicCapacidadPersonas();
        this.tiempo_vuelo = tiempo_vuelo;
        this.estado = estado;
        this.filas=filas;
        asientos = new HashMap<>(); // inicializador de filas.
        inicializarAsientos(filas);
    }

    private void inicializarAsientos(int filas) {
        for (int i = 1; i <= filas; i++) {
            Map<Character, Asiento> fila = new HashMap<>();
            // Inicializa los asientos de la A a la F en cada fila
            for (char seat = 'A'; seat <= 'F'; seat++) {
                fila.put(seat, new Asiento(i, seat));
            }
            asientos.put(i, fila);
        }
    }


    @Override
    public String toString() {
        return  "\n MODELO DE AVION: " + modelo +
                "\n CAPACIDAD: " + capacidad_personas +
                "\n TIEMPO DE COMBUSTIBLE: " + tiempo_vuelo +
                "\n TIPO: " + tipo +
                "\n ESTADO: " + estado +
                "\n (Disponi|ble(1) - Ocupado (0) - Reparacion (-1))" +
                //"\n ASIENTO: " + asientos +
                "\n \n ====================== \n";
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
    public int inicCapacidadPersonas()
    {
        return this.filas*6;
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

    public Map<Integer, Map<Character, Asiento>> getAsientos() {
        return asientos;
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
