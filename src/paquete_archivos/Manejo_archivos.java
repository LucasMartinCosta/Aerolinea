package paquete_archivos;


import Aerolinea.Reserva;
import Aviones.Avion;
import Paquete_personas.*;
import Paquetes_vuelos.Destinos;
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
import java.util.*;

public class Manejo_archivos {

    private Lista_Personas lista_personas = new Lista_Personas();
    private Lista_aviones lista_aviones = new Lista_aviones();
    private Lista_vuelos vuelos = new Lista_vuelos();
    private HashMap <Integer, Reserva> listaReservas = new HashMap<>();

    File archivo_personas = new File("ArchivoPersonas.json");
    File archivo_aviones = new File("ArchivoAviones.json");
    File archivo_vuelos = new File("ArchivoVuelos.json");
    File archivo_reservas = new File("ArchivoReservas.json");
    ObjectMapper mapper = new ObjectMapper();


    public Persona buscarPersona (String apellido, String contra)
    {
        for (Persona persona:lista_personas)
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

    public void cargararchivo_reserva() // tiene el id de reserva
    {
        try
        {
            mapper.writeValue(archivo_reservas,listaReservas);
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
            this.listaReservas = mapper.readValue(archivo_reservas, new TypeReference<HashMap<Integer, Reserva>>() {
            });
        }
        catch (IOException e)
        {
            System.out.println("No se puede leer el archivo de reservas");
        }
    }

    public void eliminarReservaEstructura(Integer id) {  //Elimina una reserva pasandole el codigo.

        boolean encontrada = false;

        Iterator<Map.Entry<Integer, Reserva>> iterator = listaReservas.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Reserva> entry = iterator.next();
            if (entry.getKey().equals(id)) {

                iterator.remove();
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("\n No se encontró ninguna reserva con el código especificado. Vuelve a intentarlo.");
        }
    }


    public void prueba () //funcion de prueba..... solo carga personas en el archivo, sirve para verificar
    {
        Cliente cliente = new Cliente("imanol", "sayago", "ima@", "ima", Genero.MASCULINO);
        Cliente cliente2 = new Cliente("Lucas", "Costa", "lucas@", "lucas",Genero.MASCULINO);
        Cliente cliente3 = new Cliente("Laura", "nomeacuerdo", "laura@", "laura",Genero.FEMENINO);


        Empleado empleado = new Empleado("manuempleado", "abras", "manu@", "manu",Genero.MASCULINO);
        Empleado empleado2 = new Empleado("imanolempleado", "sayago", "imanolempleado@", "imanolempleado",Genero.MASCULINO);
        Empleado empleado3 = new Empleado("lucasempleado", "coasdadsta", "lucasempleado@", "lucasempleado",Genero.MASCULINO);
        Empleado empleado4 = new Empleado("lucasempleado", "costa", "lucasempleado@", "1",Genero.MASCULINO);


        Admin admin = new Admin("lucasempleado", "costa", "lucasempleado@", "lucasempleado",Genero.MASCULINO);
        Admin admin1 = new Admin("lucasempleado", "admin", "lucasempleado@", "1",Genero.MASCULINO);

        lista_personas.agregar_personas(cliente);
        lista_personas.agregar_personas(cliente2);
        lista_personas.agregar_personas(cliente3);
        lista_personas.agregar_personas(empleado);
        lista_personas.agregar_personas(empleado2);
        lista_personas.agregar_personas(empleado3);
        lista_personas.agregar_personas(admin1);
        lista_personas.agregar_personas(admin);
        lista_personas.agregar_personas(empleado4);

        cargararchivo_personas();
    }

    public void prueba_aviones()
    {
        Avion avion1 = new Avion("a1",2.4,1,1);
        Avion avion2 = new Avion("a2",2.4,1,1);
        Avion avion3 = new Avion("a3",2.4,1,1);

        lista_aviones.agregar_aviones_lista(avion1);
        lista_aviones.agregar_aviones_lista(avion2);
        lista_aviones.agregar_aviones_lista(avion3);
       // cargaarchivo_aviones();
    }

    public void prueba_vuelos()
    {
        Avion a1 = new Avion("a1", 120, 1, 1);
        Vuelo v1= new Vuelo(Destinos.CORDOBA,Destinos.MISIONES,a1,2.4,"29/06/2024","18/07/2024","16:00hrs","20:00hrs",1,"mp12345", 100.);
        Vuelo v2= new Vuelo(Destinos.BUENOSAIRES,Destinos.MENDOZA,a1,2.4,"20/06/2024","10/07/2024","21:30hrs","03:00 hrs",1,"we34567", 150.);
        Vuelo v3= new Vuelo(Destinos.RIONEGRO,Destinos.CORDOBA,a1,2.4,"30/06/2024","11/07/2024","10:00hrs","16:00hrs",1,"df7890", 222.);

        vuelos.agregarvueloslista(v1);
        vuelos.agregarvueloslista(v2);
        vuelos.agregarvueloslista(v3);

        cargararchivo_vuelos();

    }

        //GETTERS Y SETTERS:
    public Lista_Personas getLista_personas() {
        return lista_personas;
    }

    public void setLista_personas(Lista_Personas lista_personas) {
        this.lista_personas = lista_personas;
    }


    public Lista_aviones getLista_aviones() {
        return lista_aviones;
    }

    public void setLista_aviones(Lista_aviones lista_aviones) {
        this.lista_aviones = lista_aviones;
    }
    public Lista_vuelos getVuelos() {
        return vuelos;
    }

    public void setVuelos(Lista_vuelos vuelos) {
        this.vuelos = vuelos;
    }

    public HashMap<Integer, Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(HashMap<Integer, Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
}
