package Aviones;

public class Avion {
    private String modelo;
    private Integer capacidad_personas;
    private double tiempo_vuelo;
    private String tipo;  /*PRIVADO O COMERCIAL*/
    private int estado;    /*Disponible(1) - Ocupado (0) - Reparacion (-1) */

    public Avion(String modelo, Integer capacidad_personas, double tiempo_vuelo, int estado) {
        this.modelo = modelo;
        this.capacidad_personas = capacidad_personas;
        this.tiempo_vuelo = tiempo_vuelo;
        this.estado = estado;
    }
}
