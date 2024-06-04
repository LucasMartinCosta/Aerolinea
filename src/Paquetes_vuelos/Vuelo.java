package Paquetes_vuelos;

import Aviones.Avion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vuelo  {
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
    private String condicionVuelo;

    public Vuelo(String origen, String destino, Avion avion, Double tiempoVuelo, LocalDate fechaSalida,
                 LocalDate fechaLlegada, LocalDateTime horaSalida, LocalDateTime horaLlegada, int estado, int codigoVuelo) {

        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
        this.tiempoVuelo = tiempoVuelo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
      setCondicionVuelo(condicionVuelo);

    }


    //este to string lo usamos para imprimir el boleto de avion
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

    public String mostrarEnReserva(){

        return "\nORG=" + origen +
                "                    DES=" + destino  +
                "\nSALIDA=" + fechaSalida +
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
      if (estado== 1 || estado==0 || estado== -1) {
          this.estado = estado;
      }else {
          System.out.println("\nNO VALIDO");
      }
    }

    public String getCondicionVuelo() {
        return condicionVuelo;
    }

    public void setCondicionVuelo(String condicionVuelo) {
      if (estado== 1){
          this.condicionVuelo ="A TIEMPO";
      } else if (estado== 0) {
          this.condicionVuelo ="RETRASADO";

      }else {
          this.condicionVuelo = "CANCELADO";
      }
    }

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
}
