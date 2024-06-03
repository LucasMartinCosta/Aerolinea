package Paquetes_vuelos;

import Aviones.Avion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vuelo {
    private String origen;
    private String destino;
    private Avion avion;
    private Double tiempoVuelo;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private LocalDateTime horaSalida;
    private LocalDateTime horaLlegada;
    private int estado; // Ok(1) - Retrasado(0) - Cancelado (-1)
    private Integer codigoVuelo;

    public Vuelo(String origen, String destino, Avion avion, Double tiempoVuelo, LocalDate fechaSalida, LocalDate fechaLlegada, LocalDateTime horaSalida, LocalDateTime horaLlegada, int estado, int codigoVuelo) {
        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
        this.tiempoVuelo = tiempoVuelo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;

    }


    @Override
    public String toString() {
        return "\nORG=" + origen +
                "                    DES=" + destino  +
                "\nDURACION= " + tiempoVuelo +
                "\nSALIDA=" + fechaSalida +
                "\n" +avion.getModelo() +
                "      " + horaSalida +
                "\nLLEGADA= " + fechaLlegada +

                "       " + horaLlegada;

    }

    public Integer getCodigoVuelo() {
        return codigoVuelo;
    }

    public Avion getAvion() {
        return avion;
    }
}
