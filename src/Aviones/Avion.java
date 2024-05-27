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
}
