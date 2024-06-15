package Paquetes_vuelos;

import Aviones.Avion;

import java.time.LocalDate;
import java.util.Objects;

public class Vuelo implements Comparable<Vuelo> {
    private Destinos origen;
    private Destinos destino;
    private Avion avion;
    private Double tiempoVuelo;
//    private LocalDate fechaSalida;
//    private LocalDate fechaLlegada;
//    private LocalDateTime horaSalida;
//    private LocalDateTime horaLlegada;
    private int estado; // Ok(1) - Retrasado(0) - Cancelado (-1)
    private String codigoVuelo;  //capaz puede ser un String
    private String condicionVuelo;
    private int numeroPasajeros;
    private Double precioVuelo;

//    LocalDate fechaSalida,
//    LocalDate fechaLlegada, LocalDateTime horaSalida, LocalDateTime horaLlegada,


    public Vuelo() {
    }

    public Vuelo(Destinos origen,Destinos destino, Avion avion, Double tiempoVuelo, int estado, String codigoVuelo, Double precioVuelo) {

        this.origen = origen;
        this.destino = destino;
        this.codigoVuelo=codigoVuelo;
        this.avion = avion;
        this.tiempoVuelo = tiempoVuelo;
//        this.fechaSalida = fechaSalida;
//        this.fechaLlegada = fechaLlegada;
//        this.horaSalida = horaSalida;
//        this.horaLlegada = horaLlegada;
        this.estado = estado;
      setCondicionVuelo(condicionVuelo);
      this.precioVuelo=precioVuelo;


    }



//    public Vuelo(String origen, String destino, LocalDate fechaSalida, int numeroPasajeros){
//        this.origen = origen;
//        this.destino = destino;
//        this.fechaSalida= fechaSalida;
//        this.numeroPasajeros = numeroPasajeros;
//
//    }

    public Vuelo(Destinos origen, Destinos destino, LocalDate fechaLlegada, int numeroPasajeros){
        this.origen = origen;
        this.destino = destino;
//        this.fechaLlegada = fechaLlegada;
        this.numeroPasajeros = numeroPasajeros;

    }


    //este to string lo usamos para imprimir el boleto de avion
//    @Override
//    public String toString() {
//        return "\nORG=" + origen +
//                "                    DES=" + destino  +
//                "\nDURACION= " + tiempoVuelo +
//                "\nSALIDA=" + fechaSalida +
//                "\n" +avion.getModelo() +
//                "      " + horaSalida +
//                "\nLLEGADA= " + fechaLlegada +
//
//                "       " + horaLlegada;
//
//    }

    public String getCodigoVuelo() {
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

    public Destinos getOrigen() {
        return origen;
    }

    public void setOrigen(Destinos origen) {
        this.origen = origen;
    }

    public Destinos getDestino() {
        return destino;
    }

    public void setDestino(Destinos destino) {
        this.destino = destino;
    }

    public Double getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(Double tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

    public Double getPrecioVuelo() {
        return precioVuelo;
    }

    public void setPrecioVuelo(Double precioVuelo) {
        this.precioVuelo = precioVuelo;
    }

    //    public LocalDate getFechaSalida() {
//        return fechaSalida;
//    }
//
//    public void setFechaSalida(LocalDate fechaSalida) {
//        this.fechaSalida = fechaSalida;
//    }
//
//    public LocalDate getFechaLlegada() {
//        return fechaLlegada;
//    }
//
//    public void setFechaLlegada(LocalDate fechaLlegada) {
//        this.fechaLlegada = fechaLlegada;
//    }

    @Override
     public int compareTo(Vuelo o) {
        return this.codigoVuelo.compareTo(o.getCodigoVuelo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return Objects.equals(codigoVuelo, vuelo.codigoVuelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoVuelo);
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", avion=" + avion +
                ", tiempoVuelo=" + tiempoVuelo +
                ", estado=" + estado +
                ", codigoVuelo=" + codigoVuelo +
                ", condicionVuelo='" + condicionVuelo + '\'' +
                ", numeroPasajeros=" + numeroPasajeros +
                '}';
    }





}


