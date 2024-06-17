package Paquete_personas;

import Aviones.Asiento;
import Aviones.Avion;
import Menus.VueloNoExisteExc;
import Paquetes_vuelos.Destinos;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import Tipos_listas.Lista_Personas;
import Tipos_listas.Lista_aviones;
import com.fasterxml.jackson.annotation.JsonTypeName;
import paquete_archivos.Manejo_archivos;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

@JsonTypeName("Empleado")
public class Empleado extends Persona implements Serializable {
    private Lista_vuelos listaVuelo;
    private Lista_Personas listaPersonas;
    private Lista_aviones listaAviones;

    Scanner scanner = new Scanner(System.in);


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

    public Vuelo crearVuelo (Manejo_archivos archivos)
    {
            Vuelo nuevo = new Vuelo();

             Destinos.elegirDestinos(nuevo);

             Avion avion = elegirAvion(archivos);
             nuevo.setAvion(avion);

        System.out.println("\nIngrese las horas totales del vuelo: ");
        Double tiempoVuelo = scanner.nextDouble();
        scanner.nextLine();
        nuevo.setTiempoVuelo(tiempoVuelo);

        System.out.println("\nIngrese la fecha de salida: ");
        String fechaSalida= scanner.nextLine();
        nuevo.setFechaIda(fechaSalida);

//        System.out.println("ingrese la fecha de vuelta: ");
//        String fechaVuelta= scanner.nextLine();
//        nuevo.setFechaVuelta(fechaVuelta);

        System.out.println("\nIngrese el horario de salida: ");
        String horariosalida= scanner.nextLine();
        nuevo.setHorarioSalida(horariosalida);

        System.out.println("\nIngrese el horario de llegada: ");
        String horarioLlegada= scanner.nextLine();
        nuevo.setHorarioLlegada(horarioLlegada);

        System.out.println("\nIngrese el estado del avion: A TIEMPO = 1 // RETRASADO=0 // CANCELADO= -1");
        int estado= scanner.nextInt();
        scanner.nextLine();
        nuevo.setEstado(estado);
        nuevo.setCondicionVuelo();

        System.out.println("\nIngrese el codigo del vuelo (Primeras 3 letras del origen - Primeras 3 letras del destino - horario llegada) ");
        System.out.println("ORIGEN = " + nuevo.getOrigen() + " LLEGADA = " + nuevo.getDestino() + " HORARIO LLEGADA = " + nuevo.getHorarioLlegada());
        String codigo= scanner.nextLine();
        nuevo.setCodigoVuelo(codigo);

        System.out.println("\nIngrese el precio del vuelo para los pasajeros: ");
        Double precio = scanner.nextDouble();
        scanner.nextLine();
        nuevo.setPrecioVuelo(precio);

        archivos.getVuelos().agregarvueloslista(nuevo);

        return nuevo;

    }

    public Avion elegirAvion (Manejo_archivos archivos) {
        Avion elegido = null;

        mostrarListaAviones(archivos);

        while (true) {
            System.out.println("\nIngrese el Modelo del avion a elegir: ");
            String modelo = scanner.nextLine();

            boolean found = false;
            for (Avion dato : archivos.getLista_aviones()) {
                if (dato.getModelo().equalsIgnoreCase(modelo)) { // Comparación insensible a mayúsculas/minúsculas
                    if (dato.getEstado() == 1) {
                        System.out.println("\nAvión elegido.");
                        elegido = dato;
                        found = true;
                        break;
                    } else {
                        System.out.println("\nEl avión no está disponible, por favor elija otro.");
                        found = true;
                        break;
                    }
                }
            }

            if (elegido != null) {
                break;
            } else if (!found) {
                System.out.println("\nModelo no encontrado, por favor elija otro.");
            }
        }
        elegido.setEstado(0);
        return elegido;
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
        try {
            Vuelo encontrado = buscarVuelo(buscado, archivo);
            if (encontrado != null) {
                System.out.println("\nIngresar estado del Vuelo (1= A Tiempo // 0= Retrasado // -1= Cancelado");
                Scanner estado = new Scanner(System.in);
                int e = estado.nextInt();
                encontrado.setEstado(e);
            } else {
                throw new VueloNoExisteExc(buscado);
            }
        }catch (VueloNoExisteExc e){
            System.out.println(e.getMessage());
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
        try {
            Vuelo aux = buscarVuelo(codBuscar, archivo);
            if (aux != null) {
                System.out.println(aux.toString() +
                        "\n --- " +
                        aux.getAvion().toString() +
                        aux.getAvion().getAsientos());
            }else {
                throw new VueloNoExisteExc(codBuscar);
            }
        }catch (VueloNoExisteExc e){
            System.out.println(e.getMessage());
        }
    }

}