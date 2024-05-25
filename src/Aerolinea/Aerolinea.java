package Aerolinea;

import Paquetes_vuelos.Vuelos;

import java.util.ArrayList;

public class Aerolinea {
    private String nombre;
    private ArrayList<Vuelos>vuelos_Aerolineas;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos_Aerolineas = new ArrayList<>();
    }




}
