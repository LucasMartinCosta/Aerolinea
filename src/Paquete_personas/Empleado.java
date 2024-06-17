package Paquete_personas;

import Aviones.Asiento;
import Aviones.Avion;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import Tipos_listas.Lista_Personas;
import Tipos_listas.Lista_aviones;
import com.fasterxml.jackson.annotation.JsonTypeName;
import paquete_archivos.Manejo_archivos;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;

@JsonTypeName("Empleado")
public class Empleado extends Persona implements Serializable {
    private Lista_vuelos listaVuelo;
    private Lista_Personas listaPersonas;
    private Lista_aviones listaAviones;


    //Constructor Persona.
    public Empleado(String nombre, String apellido, String email, String contra,Genero genero) {
    super(nombre, apellido, email, contra,genero);
    }

    //Constructor de Usuario.
    public Empleado(String email, String contra) {
        super(email, contra);
    }
    //Constructor de Listas de Aviones y Pasajeros.

    //constructor basico para manejo de listas.
    public Empleado() {
        this.listaVuelo = new Lista_vuelos();
        this.listaPersonas = new Lista_Personas();
        this.listaAviones = new Lista_aviones();
    }

        //Buscar un vuelo puntual buscado por codigo de vuelo y devuelve ese vuelo puntual o null si no existe.
    public Vuelo buscarVuelo(String vueloBuscado, Manejo_archivos archivo) {

        for (Vuelo v : archivo.getVuelos()){
            if (v.getCodigoVuelo().equals(vueloBuscado)) {
                return v;
            }
        }
        return null;
    }

    //Buscar un vuelo puntual por su codigo y modifica su estado.
    public void modificarEstadoVuelo(String buscado, Manejo_archivos archivo) {
        Vuelo encontrado = buscarVuelo(buscado, archivo);
        if (encontrado != null) {
            System.out.println("Ingresar estado del Vuelo (1= A Tiempo // 0= Retrasado // -1= Cancelado");
            Scanner estado = new Scanner(System.in);
            int e = estado.nextInt();
            encontrado.setEstado(e);
        } else {
            System.out.println("ERROR - Vuelo no encontrado.");
        }
    }

    public void mostrarListaClientes(Manejo_archivos archivo){
        for(Persona p : archivo.getLista_personas()){
            if (p instanceof Cliente){
                System.out.println(p);
            }
        }
    }
        //Este metodo va a trabajar SOLO con Clientes porque tienen el atributo pasaporte para poder buscar.
        //Lo hice ahora aca pero lo voy a agregar como un metodo de admin.
//    public Persona buscarPersona(Integer buscar){
//        for(Persona p : listaPersonas.getLista_personas()){
//            if(p instanceof Cliente && ((Cliente) p).getPasaporte().equals(buscar)){
//                return p;
//            }
//        }
//        return null;
//    }

    public void mostrarListaAviones(Manejo_archivos archivo){
        for(Avion a : archivo.getLista_aviones()){
            System.out.println(a.toString());
        }
    }
    public void mostrarListaVuelos(Manejo_archivos archivo){
        for (Vuelo v : archivo.getVuelos()){
            System.out.println(v.toString());
        }
    }

    public void verPasajerosXVuelo(String codBuscar, Manejo_archivos archivo) {
        Vuelo aux = buscarVuelo(codBuscar, archivo);
        System.out.println(
                aux.toString() +
                "\n --- " +
                aux.getAvion().toString() +
                aux.getAvion().getAsientos());
        //Increiblemente la funcion de abajo no sirve, y la pavada de arriba si sirve para mostrar todos los asientos.


//            for(Vuelo vuelo : archivo.getVuelos()){
//            if(vuelo.getCodigoVuelo().equals(codBuscar)){
//                //Segun chat gpt son 3 bucles for para acceder a asientos, segun Intellij son 2.
//                //for (Map<Integer, Map<Character, Asiento>> filaMap : vuelo.getAvion().getAsientos().values()){
//                for(Map<Character, Asiento> asientoMap : vuelo.getAvion().getAsientos().values()){
//                    for (Asiento a : asientoMap.values()){
//                        if (a.isDisponible() && a.getCliente() != null){
//                            System.out.println(a);
//                        }
//                    }
//                    //}
//                }
//            }
//        }

    }


}