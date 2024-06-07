package Paquete_personas;

import Aviones.Avion;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;

import java.util.Scanner;

public class Empleado extends Persona{

    private Vuelo vuelos;
    private Lista_vuelos listaVuelo; //no entiendo bien como deberia funcionar este atributo el viernes pregunto =)
    private Cliente clientes;
    //private Lista_cliente listaCliente
    private Avion aviones;
    //private Lista_avione listaAvione;



    //Constructor Persona.
    public Empleado(String nombre, String apellido, String email, String contra) {
        super(nombre, apellido, email, contra);
    }
    //Constructor de Usuario.
    public Empleado(String email, String contra) {
        super(email, contra);
    }
    //Constructor de Listas de Aviones y Pasajeros.


    public Empleado(Vuelo vuelos, Cliente cliente, Avion avion) {
        this.vuelos = vuelos;
        this.listaVuelo = listaVuelo;
        this.clientes = cliente;
        //this.listaClientes= listaCliente
        this.aviones = avion;
        //this.listaAviones = listaAviones;
    }
    //Buscar un vuelo puntual buscado por codigo de vuelo y devuelve ese vuelo puntual o null si no existe.
    //Lo hice de la forma que veniamos trabajando hasta ahora, esta sujeto a modificaciones.
    //Tambien estaba pensando en hacer Genericos aca, que reciba un codigo y una lista, y devuelva el objeto con su codigo.
//    public Vuelo buscarVuelo(int codigoBuscado){
//        Vuelo auxiliar = null;
//        for (Vuelo v : listaVuelo){
//            if (v.getCodigoVuelo() == codigoBuscado){
//                auxiliar= v;
//                break;
//            }
//        }
//        return auxiliar;
//    }
//    public void modificarEstadoVuelo(int codigoVuelo){
//        vuelos = buscarVuelo(codigoVuelo);
//        if (vuelos != null){
//            System.out.println("Ingresar estado del Vuelo (1= A Tiempo // 0= Retrasado // -1= Cancelado");
//            Scanner estado= new Scanner(System.in);
//            int e = estado.nextInt();
//            vuelos.setEstado(e);
//        }else {
//            System.out.println("ERROR - Vuelo no encontrado.");
//        }
//    }
//    public void mostrarUnCliente(int pasaporte){
//        clientes = buscarCliente(pasaporte);
//        if (clientes != null){
//            System.out.println(clientes.toString());
//        }else {
//            System.out.println("ERROR - Vuelo no encontrado.");
//        }
//    }




}
