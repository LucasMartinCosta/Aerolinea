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
}
