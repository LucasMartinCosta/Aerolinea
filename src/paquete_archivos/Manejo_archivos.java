package paquete_archivos;

import Aerolinea.Reserva;
import Aviones.Avion;
import Paquete_personas.Cliente;
import Paquete_personas.Empleado;
import Paquete_personas.Persona;
import Paquetes_vuelos.Vuelo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Manejo_archivos {

    private TreeSet<Persona> listaPersonas=new TreeSet<>();
    private ArrayList<Avion>listaAvion;
    private HashSet<Vuelo> listaVuelos ;
    private HashMap<Integer, Reserva> listaReservas;

    //hacer atributos de la clase archivo con todas las estructuras de datos que se creen y dsp
    //manejarlas con set y get. Gracias guille.

    File archivo_personas = new File("ArchivoPersonas.txt");
    File archivo_aviones = new File("ArchivoAviones.txt");
    File archivo_vuelos = new File("ArchivoVuelos.txt");
    File archivo_reservas = new File("ArchivoReservas.txt");
    ObjectMapper mapper = new ObjectMapper();

    ///CARGA ARCHIVO LISTA PERSONAS///

    public void cargarPersonas (Persona dato)
    {
        this.listaPersonas.add(dato);
    }

    public void prueba () //funcion de prueba..... solo carga personas en el archivo, sirve para verificar
    {
        Cliente cliente = new Cliente("1", "2", "3", "");
        Cliente cliente2 = new Cliente("asd", "dsa", "111", "cxz");
        Cliente cliente3 = new Cliente("234", "", "", "gfdsss");

        Empleado empleado = new Empleado("zxcr", "", "wtgfd", "", "");
        Empleado empleado2 = new Empleado("", "rwe", "", "", "");
        Empleado empleado3 = new Empleado("", "aaa", "", "aaa", "");

        this.listaPersonas.add(cliente);
        this.listaPersonas.add(cliente2);
        this.listaPersonas.add(cliente3);
        this.listaPersonas.add(empleado);
        this.listaPersonas.add(empleado2);
        this.listaPersonas.add(empleado3);

        cargararchivo_personas(listaPersonas);
    }

    public Persona buscarPersona (String apellido, String contra)
    {
        for (Persona persona:listaPersonas)
        {
            if (persona.getApellido().equals(apellido) && persona.getContra().equals(contra))
            {
                return persona;
            }
        }
        return null;
    }


    public void cargararchivo_personas(TreeSet<Persona>lista){

        try{
            mapper.writeValue(archivo_personas,lista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leer_todo_archivo_personas()
    {
        try {
            this.listaPersonas= mapper.readValue(archivo_personas, new TypeReference<TreeSet<Persona>>() {
            });
        }
        catch (IOException e) {
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

    public void leer_archivo_aviones()
    {
        try {
            this.listaAvion = mapper.readValue(archivo_aviones, new TypeReference<ArrayList<Avion>>() {
            });
            System.out.println("fue cargada papa");
        }
        catch (IOException e)
        {
            System.out.println("No entro al try ptm");
        }
    }

    ///Carga FILES PAQUETE VUELOS///
    public void cargararchivo_paquetes(HashSet<Vuelo>lista_vuelos)
    {
        try {
            System.out.println("entro");
            mapper.writeValue(archivo_vuelos, lista_vuelos);
            System.out.println("ANDA CHETO");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void leerarchivo_paquetes()
    {
        try
        {
            this.listaVuelos =  mapper.readValue(archivo_vuelos, new TypeReference<HashSet<Vuelo>>() {
            });
        }
        catch (IOException e)
        {
            System.out.println("Noo entro al try ptm");
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

    public void leerarchivo_reserva()
    {
        try {
            this.listaReservas = mapper.readValue(archivo_reservas, new TypeReference<HashMap>() {
            });
        }
        catch (IOException e)
        {
            System.out.println("Noo entro al try ptm");
        }
    }

    public void mostrararchivopersonas()
    {

        for(Persona personita: listaPersonas)
        {
            System.out.println(personita.toString());
        }
    }

    public void mostrararchivoAviones()
    {
        for (Avion a: this.listaAvion)
        {
            System.out.println(a);
        }
    }

    public TreeSet<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Avion> getListaAvion() {
        return listaAvion;
    }

    public HashSet<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public HashMap<Integer, Reserva> getListaReservas() {
        return listaReservas;
    }


}
