package Paquete_personas;

import Aviones.Avion;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;

public class Empleado extends Persona{

    private Vuelo vuelos;
    private Lista_vuelos listaVuelo;



    public Empleado(String nombre, String apellido, String email,String contra, String genero) {
        super(nombre, apellido, email, contra);
    }



}
