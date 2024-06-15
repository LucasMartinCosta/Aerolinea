package paquete_archivos;


import Aerolinea.Reserva;
import Aviones.Avion;
import Paquete_personas.Cliente;
import Paquete_personas.Empleado;
import Paquete_personas.Persona;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import Tipos_listas.Lista_Personas;
import Tipos_listas.Lista_aviones;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Manejo_archivos {

    private Lista_Personas lista_personas = new Lista_Personas();
    private Lista_aviones lista_aviones = new Lista_aviones();
    private Lista_vuelos vuelos = new Lista_vuelos();
    private HashMap<Integer, Reserva> listaReservas;


    File archivo_personas = new File("ArchivoPersonas.json");
    File archivo_aviones = new File("ArchivoAviones.json");
    File archivo_vuelos = new File("ArchivoVuelos.json");
    File archivo_reservas = new File("ArchivoReservas.json");
    ObjectMapper mapper = new ObjectMapper();






    public Persona buscarPersona (String apellido, String contra)
    {
        for (Persona persona:lista_personas.getLista_personas())
        {
            if (persona.getApellido().equals(apellido) && persona.getContra().equals(contra))
            {
                return persona;
            }
        }

        return null;
    }

    ///CARGA ARCHIVO LISTA PERSONAS///
    public void cargararchivo_personas(){

        try{
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(archivo_personas,lista_personas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leerarchivo_personas() {
        try {
            JsonNode rootNode = mapper.readTree(archivo_personas);
            JsonNode listaPersonasNode = rootNode.get("lista_personas");

            TreeSet<Persona> personas = mapper.readValue(listaPersonasNode.toString(), new TypeReference<TreeSet<Persona>>() {});

            // Deserializar el array de personas en un TreeSet
            TreeSet<Persona> aux = mapper.readValue(
                    listaPersonasNode.toString(),
                    new TypeReference<TreeSet<Persona>>() {}
            );

            // Asignar el TreeSet al campo setListaPersonas
            lista_personas.setLista_personas(aux);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public void leer_todo_archivo_personas()
//    {
//        try {
//            TreeSet<Persona>aux;
//            aux = mapper.readValue(archivo_personas, new TypeReference<TreeSet<Persona>>() {
//            });
//            System.out.println("Ya leyo el archivo, hasta aca todo bien");
//
//            lista_personas.setLista_personas(aux);
//        }
//        catch (IOException e) {
//            System.out.println("Error al querer leer el archivo");
//            throw new RuntimeException(e);
//        }
//    }

    ///Carga archivo aviones///

    public void cargaarchivo_aviones()
    {
        try {
            mapper.writeValue(archivo_aviones,lista_aviones.getLista_aviones());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leer_archivo_aviones()
    {
        try {
            ArrayList<Avion> aux;
            aux= mapper.readValue(archivo_aviones, new TypeReference<ArrayList<Avion>>() {
            });
            lista_aviones.setLista_aviones(aux);
        }
        catch (IOException e)
        {
           throw new RuntimeException(e);
        }
    }

    ///Carga FILES PAQUETE VUELOS///
    public void cargararchivo_vuelos()
    {
        try {

            mapper.writeValue(archivo_vuelos, vuelos.getLista_vuelos());

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void leerarchivo_vuelos()
    {
        try
        {
            HashSet<Vuelo> aux  =  mapper.readValue(archivo_vuelos, new TypeReference<HashSet<Vuelo>>() {
            });
            vuelos.setLista_vuelos(aux);
        }
        catch (IOException e)
        {
           throw new RuntimeException(e);
        }
    }

    public void cargararchivo_reserva(HashMap<Integer,Reserva> lista_reservas) // tiene el id de reserva
    {
        try
        {
            mapper.writeValue(archivo_reservas,lista_reservas);
        }
        catch (IOException e)
        {
            System.out.println("No se puede cargar el archivo");
            throw new RuntimeException(e);

        }
    }

    public void leerarchivo_reserva()
    {
        try {
            this.listaReservas = mapper.readValue(archivo_reservas, new TypeReference<HashMap>() {
            });
        }
        catch (IOException e)
        {
            System.out.println("No se puede leer el archivo de reservas");
        }
    }

    public TreeSet<Persona> getListaPersonas() {return lista_personas.getLista_personas();
    }

    public ArrayList<Avion> getListaAvion() {
        return lista_aviones.getLista_aviones();
    }

    public HashMap<Integer, Reserva> getListaReservas() {
        return listaReservas;
    }



    public void prueba () //funcion de prueba..... solo carga personas en el archivo, sirve para verificar
    {
        Cliente cliente = new Cliente("imanol", "sayago", "ima@", "ima");
        Cliente cliente2 = new Cliente("Lucas", "Costa", "lucas@", "lucas");
        Cliente cliente3 = new Cliente("Laura", "nomeacuerdo", "laura@", "laura");


        Empleado empleado = new Empleado("manuempleado", "abras", "manu@", "manu");
        Empleado empleado2 = new Empleado("imanolempleado", "sayago", "imanolempleado@", "imanolempleado");
        Empleado empleado3 = new Empleado("lucasempleado", "costa", "lucasempleado@", "lucasempleado");

        lista_personas.agregar_personas(cliente);
        lista_personas.agregar_personas(cliente2);
        lista_personas.agregar_personas(cliente3);
        lista_personas.agregar_personas(empleado);
        lista_personas.agregar_personas(empleado2);
        lista_personas.agregar_personas(empleado3);

        cargararchivo_personas();
    }

    public void prueba_aviones()
    {
        Avion avion1 = new Avion("a1",20,2.4,1,1);
        Avion avion2 = new Avion("a2",20,2.4,1,1);
        Avion avion3 = new Avion("a3",20,2.4,1,1);

        lista_aviones.getLista_aviones().add(avion1);
        lista_aviones.getLista_aviones().add(avion2);
        lista_aviones.getLista_aviones().add(avion3);
        cargaarchivo_aviones();
    }

    public void prueba_vuelos()
    {
        Avion a1 = new Avion();
        Vuelo v1= new Vuelo("mar del plata","NY",a1,2.4,1,"mdp.ny.a1", 100.);
        Vuelo v2= new Vuelo("Coronel Vidal","NY",a1,2.4,1,"cv.ny.a1", 150.);
        Vuelo v3= new Vuelo("CHACO","NY",a1,2.4,1,"ch.ny.a1", 222.);


        vuelos.agregarvueloslista(v1);
        vuelos.agregarvueloslista(v2);
        vuelos.agregarvueloslista(v3);

        cargararchivo_vuelos();

    }

    public Lista_vuelos getVuelos() {
        return vuelos;
    }

    public void setVuelos(Lista_vuelos vuelos) {
        this.vuelos = vuelos;
    }
}
