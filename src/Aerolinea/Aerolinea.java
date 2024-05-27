package Aerolinea;

import Paquetes_vuelos.Vuelo;
import Paquetes_vuelos.Vuelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Aerolinea {
    private String nombre;
    private HashMap<Integer,Vuelo> vuelos_Aerolineas;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos_Aerolineas = new HashMap<>();
    }

    public void agregarVuelos(Integer i, Vuelo v){
        Vuelo vuelos =new Vuelo(v);
        vuelos_Aerolineas.put(i,v);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // equals para que no se repita la aerolinea o chequeamos?




}
