package Paquete_personas;

import Aerolinea.Reserva;
import Paquetes_vuelos.Vuelo;

import java.io.Console;
//import java.lang.classfile.Attribute;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente extends Persona  {

    private Integer pasaporte;
    private LocalDate nacimiento;
    private int edad;
    private long numTelefono;
    private String contrasenia;
    private ArrayList<Vuelo> vuelos_comprados = new ArrayList<>();
    private HashMap<Integer, Reserva> reservas = new HashMap<>(); //arraylist con reservas de cada cliente

    public Cliente(String nombre, String apellido, String email, Integer pasaporte, LocalDate nacimiento, int edad,long numTelefono) {
        super(nombre, apellido, email);
        this.pasaporte = pasaporte;
        this.nacimiento = nacimiento;
        this.edad = edad ;
        this.numTelefono = numTelefono;
    }

    public Cliente(String nombre, String apellido, String email) {

        super(nombre, apellido, email);
    }

    public HashMap<Integer, Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPasaporte= " + pasaporte +
                "\nFecha de nacimiento= "+ nacimiento;


    }

    public void comprarvuelo(int codigo, int cantidadcompras, Vuelo a)
    {
        int i=0;
        int flag =0;
        while(codigo!= vuelos_comprados.get(i).getCodigoVuelo() && flag==0)
        {
            if(codigo == vuelos_comprados.get(i).getCodigoVuelo())
            {
                flag=1;
                if(vuelos_comprados.get(i).getAvion().getCapacidad_personas()>cantidadcompras)
                {
                    vuelos_comprados.add(a);
                    System.out.println("La compra fue realizada con exito");
                }
            }
            i++;
        }
    }







//    // Método para comprar vuelos
//    public void comprarVuelo(int codigo, int cantidadCompras, Vuelo vuelo) {
//        // Verificar si el vuelo está disponible y hay suficientes asientos
//        if (vuelo.getCapacidadDisponible() >= cantidadCompras) {
//            // Comprar la cantidad especificada de asientos en el vuelo
//            for (int i = 0; i < cantidadCompras; i++) {
//                vuelos_comprados.add(vuelo);
//                vuelo.reservarAsiento(); // Restar un asiento a la capacidad disponible del vuelo
//            }
//            System.out.println("La compra fue realizada con éxito.");
//        } else {
//            System.out.println("No hay suficientes asientos disponibles en este vuelo.");
//        }
//    }

    //CONSOLE ES PARA QUE NO SE VEA LA CONTRA CUANDO INICIA SESION
//    public void iniciarSesion(){
//        Console console = System.console();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("\nEMAIL: ");
//        scan ;
//        if ()
//
//            char[] passwordArray = console.readPassword("\nCONTRASEÑA=: ");
//        this.contrasenia = new String(passwordArray);
//
//    }


}
