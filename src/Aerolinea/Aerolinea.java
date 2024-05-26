package Aerolinea;

import Paquetes_vuelos.Vuelo;
import Paquetes_vuelos.Vuelo;

import java.util.ArrayList;

public class Aerolinea {
    private String nombre;
    private ArrayList<Vuelo>vuelos_Aerolineas;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos_Aerolineas = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // equals para que no se repita la aerolinea o chequeamos?




}
