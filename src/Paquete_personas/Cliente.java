package Paquete_personas;

import Aerolinea.Reserva;
import Paquetes_vuelos.Vuelo;

import java.io.Console;
//import java.lang.classfile.Attribute;
import java.time.LocalDate;
import java.util.*;

public class Cliente extends Persona  {

    private Integer pasaporte;
    private LocalDate nacimiento;
    private int edad;
    private long numTelefono;
    private String contrasenia;
  private ArrayList<Vuelo> vuelos_comprados;
   private HashMap<Integer, Reserva> reservas; //arraylist con reservas de cada cliente

    public Cliente(String nombre, String apellido, String email,String contra, Integer pasaporte, LocalDate nacimiento, int edad,long numTelefono) {
        super(nombre, apellido, email, contra);
        this.pasaporte = pasaporte;
        this.nacimiento = nacimiento;
        this.edad = edad ;
        this.numTelefono = numTelefono;
        this.reservas = new HashMap<>();
        this.vuelos_comprados = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, String email, String contra) {
        super(nombre, apellido, email, contra);
    }

    public Cliente(String nombre, String apellido, String email,String contra, Integer pasaporte) {
        super(nombre, apellido, email, contra);
        this.pasaporte = pasaporte;
    }


    @Override
    public String toString() {
        return super.toString() +
                "\nPasaporte= " + pasaporte +
                "\nFecha de nacimiento= "+ nacimiento;


    }

    public void eliminarReserva() {
        boolean encontrada = false;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\n-------------------\n");
            System.out.println("\nCODIGO DE RESERVA:");
            int codigoReserva = Integer.parseInt(scan.nextLine());


            Iterator<Map.Entry<Integer, Reserva>> iterator = reservas.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Reserva> entry = iterator.next();
                if (entry.getKey() == codigoReserva) {

                    iterator.remove();
                    System.out.println("Reserva eliminada con éxito.");
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                System.out.println("No se encontró ninguna reserva con el código especificado. Vuelve a intentarlo.");
            }
        } while (!encontrada);
    }

    public Integer getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(Integer pasaporte) {
        this.pasaporte = pasaporte;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ArrayList<Vuelo> getVuelos_comprados() {
        return vuelos_comprados;
    }

    public void setVuelos_comprados(ArrayList<Vuelo> vuelos_comprados) {
        this.vuelos_comprados = vuelos_comprados;
    }

    public HashMap<Integer, Reserva> getReservas() {
        return reservas;
    }


    public void modificarReserva() {
        Scanner scan = new Scanner(System.in);

        // Mostrar todas las reservas del cliente
        if (reservas.isEmpty()) {
            System.out.println("\nNo tiene reservas.");
            return;
        }
        System.out.println("\nRESERVAS:");
        for (Map.Entry<Integer, Reserva> entry : reservas.entrySet()) {
            System.out.println("\nID: " + entry.getKey() + " - Reserva: " + entry.getValue());
        }

        // Solicitar al cliente que ingrese el código de reserva que desea modificar
        System.out.println("\nIngrese el ID de la reserva que desea modificar:");
        int codigoReserva = Integer.parseInt(scan.nextLine());

        // Obtener la reserva seleccionada por el cliente
        Reserva reserva = reservas.get(codigoReserva);
        if (reserva != null) {
            // Aquí puedes implementar la lógica para modificar la reserva
            // Por ejemplo, puedes permitir al usuario modificar la fecha, el asiento, etc.
            System.out.println("\nReserva seleccionada:");
            System.out.println("\nMODIFICAR:");
            System.out.println("\n1.Salida");
            System.out.println("\n1.Llegada");

            // Aquí puedes solicitar al usuario los cambios que desea realizar en la reserva
            // Luego puedes actualizar la reserva con los nuevos valores
        } else {
            System.out.println("No se encontró ninguna reserva con el ID especificado.");
        }
    }

    //si modificamos la reseva tenems q crear un nuevo vuelo si so ? no se como hacerlo



//    public void comprarvuelo(int codigo, int cantidadcompras, Vuelo a)
//    {
//        int i=0;
//        int flag =0;
//        while(codigo!= vuelos_comprados.get(i).getCodigoVuelo() && flag==0)
//        {
//            if(codigo == vuelos_comprados.get(i).getCodigoVuelo())
//            {
//                flag=1;
//                if(vuelos_comprados.get(i).getAvion().getCapacidad_personas()>cantidadcompras)
//                {
//                    vuelos_comprados.add(a);
//                    System.out.println("La compra fue realizada con exito");
//                }
//            }
//            i++;
//        }
//    }









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
