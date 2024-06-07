package Paquete_personas;

import Aviones.Avion;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import Tipos_listas.Lista_Personas;
import Tipos_listas.Lista_aviones;

import java.util.Scanner;

public class Empleado extends Persona{

    private Lista_vuelos listaVuelo;
    private Lista_Personas listaPersonas;
    private Lista_aviones listaAviones;



    //Constructor Persona.
    public Empleado(String nombre, String apellido, String email, String contra) {
        super(nombre, apellido, email, contra);
    }
    //Constructor de Usuario.
    public Empleado(String email, String contra) {
        super(email, contra);
    }
    //Constructor de Listas de Aviones y Pasajeros.


    public Empleado() {

        this.listaVuelo = new Lista_vuelos();
        this.listaPersonas = new Lista_Personas();
        this.listaAviones = new Lista_aviones();
    }
    //Buscar un vuelo puntual buscado por codigo de vuelo y devuelve ese vuelo puntual o null si no existe.
    //Lo hice de la forma que veniamos trabajando hasta ahora, esta sujeto a modificaciones.
    //Tambien estaba pensando en hacer Genericos aca, que reciba un codigo y una lista, y devuelva el objeto con su codigo.

    public Vuelo buscarVuelo(int vueloBuscado){
        for (Vuelo v: listaVuelo.getLista_vuelos()) {
            if(v.getCodigoVuelo().equals(vueloBuscado)) {
                return v;
            }
        }
        return null;
    }
    public void modificarEstadoVuelo(int buscado){
        Vuelo encontrado = buscarVuelo(buscado);
        if (encontrado != null){
            System.out.println("Ingresar estado del Vuelo (1= A Tiempo // 0= Retrasado // -1= Cancelado");
            Scanner estado= new Scanner(System.in);
            int e = estado.nextInt();
            encontrado.setEstado(e);
        }else {
            System.out.println("ERROR - Vuelo no encontrado.");
        }
    }
//    public void mostrarUnCliente(int pasaporte){
//        clientes = buscarCliente(pasaporte);
//        if (clientes != null){
//            System.out.println(clientes.toString());
//        }else {
//            System.out.println("ERROR - Vuelo no encontrado.");
//        }
    }





