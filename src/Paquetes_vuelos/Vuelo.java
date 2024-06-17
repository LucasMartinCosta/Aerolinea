package Paquetes_vuelos;

import Aviones.Avion;

import java.util.Objects;

public class Vuelo implements Comparable<Vuelo> {
    private Destinos origen;
    private Destinos destino;
    private Avion avion;
    private Double tiempoVuelo;
    private String fechaIda;
    private String fechaVuelta;
    private String horarioLlegada;
    private String horarioSalida;

    private int estado; // Ok(1) - Retrasado(0) - Cancelado (-1)
    private String codigoVuelo;  //capaz puede ser un String
    private String condicionVuelo;
    //private int numeroPasajeros;
    private Double precioVuelo;




    public Vuelo() {
    }

    //ESTE LO USAMOS PARA CREAR LOS VUELOS POR EJEMPLO EN EL MENU DEL CLIENTE CUANDO VA A COMPRAR VUELOS

    public Vuelo(Destinos origen,Destinos destino, Avion avion, Double tiempoVuelo,String fechaIda, String fechaVuelta, String horarioSalida, String horarioLlegada, int estado, String codigoVuelo, Double precioVuelo) {

        this.origen = origen;
        this.destino = destino;
        this.codigoVuelo=codigoVuelo;
        this.avion = avion;
        this.tiempoVuelo = tiempoVuelo;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada= horarioLlegada;
        this.estado = estado;
        setCondicionVuelo();
        this.precioVuelo=precioVuelo;


    }



//este to string lo usamos para imprimir el boleto de avion

    public String mostrarPasaje() {
        return "\n ORIGEN: " + origen + " - " +
                " DESTINO: " + destino  +
                "\n DURACION: " + tiempoVuelo +
                "\n SALIDA: " + fechaIda + " - " +  horarioSalida+
                "\n LLEGADA: " + fechaVuelta + " - " + horarioLlegada +
                "\n" + avion.getModelo();
    }

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
      if (estado == 1 || estado==0 || estado== -1) {
          this.estado = estado;
      }else {
          System.out.println("\nNO VALIDO");
      }
    }

    public String getCondicionVuelo() {
        return condicionVuelo;
    }

    public void setCondicionVuelo() {
      if (estado == 1){
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

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

    public String getFechaVuelta() {
        return fechaVuelta;
    }

    public void setFechaVuelta(String fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public String getHorarioLlegada() {
        return horarioLlegada;
    }

    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

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
        return
                "\n ORIGEN: " + origen + " - " +
                " DESTINO: " + destino +
                "\n MODELO DE AVION: " + avion.getModelo() +
                "\n TIEMPO DE VUELO:" + tiempoVuelo +
                "\n CODIGO DE VUELO: " + codigoVuelo +
                "\n CONDICION DE VUELO: " + condicionVuelo;
    }





}


