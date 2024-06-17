package Paquete_personas;

import Aviones.Avion;
import Paquetes_vuelos.Vuelo;
import Tipos_listas.Lista_Personas;
import Tipos_listas.Lista_aviones;
import com.fasterxml.jackson.annotation.JsonTypeName;
import paquete_archivos.Manejo_archivos;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

@JsonTypeName("Admin")
public class Admin extends Empleado implements Serializable {

    Scanner lector = new Scanner(System.in);

    public Admin(String nombre, String apellido, String email, String contra,Genero genero) {
        super(nombre, apellido, email, contra,genero);
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return super.toString()+"Admin{}";
    }

    public void crearAvion(Manejo_archivos archivo) //Ima: Creas un avion, lo sube a la lista y luego lo guarda en el archivo//
    {
        String modelo;
        System.out.println("Ingrese el modelo del avion");
        modelo=lector.nextLine();

        int capacidad;
        System.out.println("Ingrese la capacidad maxima de pesonas del avion");
        capacidad=lector.nextInt();
        lector.nextLine();

        double tiempovuelo;
        System.out.println("Ingrese las horas de tiempo de vuelo maximo del avion");
        tiempovuelo=lector.nextDouble();

        int estado;
        System.out.println("Ingrese el estado del vuelo Disponi|ble (1) - Ocupado (0) - Reparacion (-1) ");
        estado=lector.nextInt();
        lector.nextLine();

        int filas;
        System.out.println("Ingrese las filas que contiene el avion");
        filas=lector.nextInt();
        lector.nextLine();

        Avion avion = new Avion(modelo,tiempovuelo,estado,filas);

        archivo.getLista_aviones().agregar_aviones_lista(avion);
    }

    public void crearEmpleado(Manejo_archivos archivos)  //Ima: Creas un empleado siendo administrador, lo guarda en la lista y lo sube al archivo///
    {

//        Lista_Personas listapersonasaux;
//        listapersonasaux = archivos.leerarchivo_personas();


        String nombre;
        System.out.println("Ingrese el nombre del empleado: ");
        nombre=lector.nextLine();

        String apellido;
        System.out.println("Ingrese el apellido del empleado: ");
        apellido=lector.nextLine();

        String email;
        System.out.println("Ingrese el Email del empleado: ");
        email=lector.nextLine();

        String contra;
        System.out.println("Ingrese la contraseña del empleado: ");
        contra=lector.nextLine();

        int opcion;

        Genero genero=null;

        System.out.println("ingrese 1 si el empleado es Masculino:");
        System.out.println("Ingrese 2 si el empleado es femenino:");
        System.out.println("Ingrese 3 si el empleado no se identifica con ningun concepto dado anteriormente");
        opcion=lector.nextInt();
        lector.nextLine();

        switch (opcion)
        {
            case 1:
                genero= Genero.MASCULINO;
                break;

            case 2:
                genero= Genero.FEMENINO;
                break;

            case 3:
                genero= Genero.OTROS;
                break;
        }

        Empleado nuevo = new Empleado(nombre,apellido,email,contra,genero);

        archivos.getLista_personas().agregar_personas(nuevo);
        //archivos.cargararchivo_personas();
    }

    public void eliminaavionModoIma(Avion dato, Manejo_archivos archivos)//Ima: busca el avion, lo elimina, setea la nueva lista a la lista del avion y carga el archivo
    {

        //for(Avion avi : archivos.getLista_aviones()) //LUCAS: creo que para solucionar este error hay que implementar la interfaz iterable en la clase Lista_Aviones como hice en la clase Lista_vuelos. Preguntar cualquier cosa
//        {
//            if(avi.equals(dato))
//            {
//                aux.getLista_aviones().remove(avi);
//                System.out.println("Avion eliminado con exito");
//            }
//        }
//        archivos.setLista_aviones(aux);
//        archivos.cargaarchivo_aviones();
    }

    public void eliminaAvion(Avion avionAEliminar, Manejo_archivos archivos) //Ima: esto me tiro chatgpt
    {
        //Lista_aviones listaAviones = archivos.leer_archivo_aviones();

//        Iterator<Avion> iterator = listaAviones.getLista_aviones().iterator();
//        while (iterator.hasNext()) {
//            Avion avion = iterator.next();
//            if (avion.equals(avionAEliminar)) {
//                iterator.remove();
//                System.out.println("Avión eliminado con éxito");
//                break;  // Termina el bucle una vez que se elimina el avión
//            }
//        }
//
//        // Actualiza la lista de aviones en el archivo
//        archivos.setLista_aviones(listaAviones);
//        archivos.cargaarchivo_aviones();
    }

    public void verempleados(Manejo_archivos archi)
    {
        for (Persona ar: archi.getLista_personas().getLista_personas())
        {
            if(ar instanceof Empleado)
            {

                if(ar instanceof Admin)
                {

                }
                else
                {
                    System.out.println(ar.toString());
                }
            }
        }
    }


}