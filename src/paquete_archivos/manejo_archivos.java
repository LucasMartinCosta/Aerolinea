package paquete_archivos;

import Aerolinea.Reserva;
import Aviones.Avion;
import Paquete_personas.Persona;
import Paquetes_vuelos.Vuelo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class manejo_archivos {

    private TreeSet<Persona> listaPersonas = leer_todo_archivo_personas();

    private ArrayList<Avion>listaAvion = leer_archivo_aviones();

    private HashSet<Vuelo> listaVuelos = leerarchivo_paquetes();

    private HashMap<Integer, Reserva> listaReservas = leerarchivo_reserva();

    //hacer atributos de la clase archivo con todas las estructuras de datos que se creen y dsp
    //manejarlas con set y get. Gracias guille.

    File archivo_personas = new File("archivoPersonas.txt");
    File archivo_aviones = new File("archivoAviones.txt");
    File archivo_vuelos = new File("archivoPaquetes.txt");
    File archivo_reservas = new File("archivoReserva.txt");


    ObjectMapper mapper = new ObjectMapper();

    ///CARGA ARCHIVO LISTA PERSONAS///
    public void cargararchivo_personas(TreeSet<Persona>lista) throws IOException {

        try{
            mapper.writeValue(archivo_personas,lista);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public TreeSet<Persona> leer_todo_archivo_personas()
    {
        try {
            return mapper.readValue(archivo_personas, new TypeReference<TreeSet<Persona>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ///Carga archivo aviones///

    public void cargaarchivo_aviones(ArrayList<Avion> lista_aviones)
    {
            try {
                mapper.writeValue(archivo_aviones,lista_aviones);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public ArrayList<Avion> leer_archivo_aviones()
    {
        try {
           return mapper.readValue(archivo_aviones, new TypeReference<ArrayList<Avion>>() {
           });
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    ///Carga FILES PAQUETE VUELOS///
    public void cargararchivo_paquetes(HashSet<Vuelo>lista_vuelos)
    {
        try {
            mapper.writeValue(archivo_vuelos, lista_vuelos);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public HashSet<Vuelo> leerarchivo_paquetes()
    {
        try
        {
            return mapper.readValue(archivo_vuelos, new TypeReference<HashSet<Vuelo>>() {
            });
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
            throw new RuntimeException(e);
        }
    }

    public HashMap leerarchivo_reserva()
    {
        try {
            return mapper.readValue(archivo_reservas, new TypeReference<HashMap>() {
            });
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
