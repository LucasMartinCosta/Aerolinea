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
    private int estado; // Ok(1) - Retrasado(0) - Cancelado (-1) hacemos enum?


    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Double getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(Double tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    // este to string puede funcionar como mostrar tarjeta de embarque y mostrar cuando compras el vuelo


    @Override
    public String toString() {
        return "\n---Vuelo---\n" +
                "Origen= " + origen + "         " +
                "Destino=" + destino +
                "" + avion.toString() +
                "\nDuracion= " + tiempoVuelo +
                "Salida= " + fechaSalida + "       "+
                "Horario=" + horaSalida +
                "\nLlegada= " + fechaLlegada +  "      "+
                "Horario=" + horaLlegada +
                "\nEstado=" + estado
                +"\n--------------";
    }
}
