package Paquetes_vuelos;

import Aviones.Avion;

public class Vuelos {
    private String destino;
    private double valor;
    Avion avion;

    public Vuelos(String destino, double valor, Avion avion) {
        this.destino = destino;
        this.valor = valor;
        this.avion = avion;
    }
}
