package Aviones;

public class Avion {
    private String modelo;
    private Integer capacidad_personas;
    private double tiempo_vuelo;
    private String tipo;  /*PRIVADO O COMERCIAL*/
    private char estado;    /*Ocupado-Reparacion etc*/

    public Avion(String modelo, Integer capacidad_personas, double tiempo_vuelo, char estado) {
        this.modelo = modelo;
        this.capacidad_personas = capacidad_personas;
        this.tiempo_vuelo = tiempo_vuelo;
        this.estado = estado;
    }
}
