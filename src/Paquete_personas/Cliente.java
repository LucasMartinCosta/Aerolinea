package Paquete_personas;

import Aerolinea.Reserva;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;

import java.io.Console;
//import java.lang.classfile.Attribute;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Cliente extends Persona implements Serializable {
    private Integer pasaporte;
    private int edad;
    private long numTelefono;
    private String contrasenia;
    private HashMap<Integer, Reserva> reservas; //hashMap con reservas de cada cliente

    private Scanner scan = new Scanner(System.in);

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String contra) {
        super(nombre, apellido, email, contra);
    }

    public Cliente(String nombre, String apellido, String email,String contra, Integer pasaporte, int edad,long numTelefono) {
        super(nombre, apellido, email, contra);
        this.pasaporte = pasaporte;
        this.edad = edad ;
        this.numTelefono = numTelefono;
        this.reservas = new HashMap<>();
    }

    public void agregarReserva (Reserva reserva)
    {
        reservas.put(reserva.getId(), reserva);
    }

    public Vuelo elegirVueloAComprar (Lista_vuelos listaVuelos)
    {
        for (Vuelo vuelo:listaVuelos)
        {
            System.out.println("CODIGO: " + vuelo.getCodigoVuelo() + "\n"+  //Capaz que se pueden agregar las fechas
                    "ORIGEN: "+vuelo.getOrigen() +"\n"+
                    "DESTINO: "+vuelo.getDestino());
        }
        System.out.println("Ingrese el codigo del vuelo a comprar");
        String codigo = scan.nextLine();

        Vuelo buscado=listaVuelos.getLista_vuelos().BUSCARVUELO (codigo); //HAY QUE AGREGAR LA FUNCION QUE BUSCA EL VUELO POR EL CODIGO
        //funcion de buscar vuelo con el codigo leido

        return buscado;
    }

    public Double comprarAsientos (Vuelo dato)
    {
        Integer continuar = 1;
        Double totalCompra = 0.;

        while (continuar==1)
        {
            dato.getAvion().mostrarAsientos();
            int flag=0;
            char letra='a';
            System.out.println("Ingrese la fila del asiento");
            int filaElegida =scan.nextInt();

            while (flag==0)
            {
                System.out.println("Ingrese la letra del asiento");
                String input = scan.next();
                if (input.length() == 1) {
                    letra = input.charAt(0);
                    flag=1;
                } else {
                    System.out.println("Por favor, ingrese un solo carácter.");
                }
                scan.close();
            }
            dato.getAvion().comprarAsiento(this,filaElegida,letra);
            totalCompra=totalCompra+dato.getPrecioVuelo();

            System.out.println("ingrese 1 para comprar otro asiento o 0 para salir");
            continuar= scan.nextInt();
        }
        return totalCompra;
    }




    public void eliminarReserva() {  //Elimina una reserva pasandole el codigo.
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
                    System.out.println("\nReserva eliminada con éxito.");
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                System.out.println("\nNo se encontró ninguna reserva con el código especificado. Vuelve a intentarlo.");
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


    public HashMap<Integer, Reserva> getReservas() {
        return reservas;
    }


    public void modificarReserva() {
        Scanner scan = new Scanner(System.in);

        if (reservas.isEmpty()) {
            System.out.println("\nNo tiene reservas.");
            return;
        }
        System.out.println("\nRESERVAS:");
        for (Map.Entry<Integer, Reserva> entry : reservas.entrySet()) {
            System.out.println("\nID: " + entry.getKey() + " - Reserva: " + entry.getValue());
        }

        System.out.println("\nIngrese el ID de la reserva que desea modificar:");
        int codigoReserva = Integer.parseInt(scan.nextLine());

        Reserva reserva = reservas.get(codigoReserva);
        if (reserva != null) {
            System.out.println("\nReserva seleccionada: " + reserva);
            System.out.println("\nMODIFICAR:");
            System.out.println("\n1.Salida");
            System.out.println("\n1.Llegada");

//si modificamos la reseva tenemos q crear un nuevo vuelo si so ? no se como hacerlo
        } else {
            System.out.println("\nNo se encontró ninguna reserva con el ID especificado.");
        }

    }


     //muestra reserva  ESPECIFICA ENTRANDO CON UN ID OSEA LA KEY DE EL HASHMAP no PASAJE
//    public void mostrarReserva() {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("\n-------------------\n");
//        System.out.println("\nCODIGO DE RESERVA:");
//           Integer id1 = Integer.parseInt(scan.nextLine());
//        if (reservas.isEmpty()) {
//            System.out.println("\nNo tiene reservas.");
//            return;
//        }
//        for (Map.Entry<Integer, Reserva> entry : reservas.entrySet()) {
//            Reserva reserva = entry.getValue();
//
//            if (entry.getKey().equals(id1)) {
//                System.out.println("\nReserva encontrada:");
//                System.out.println("ID: " + entry.getKey() + " " ); nose como mostrar la reserva
//                return;
//            }
//        }
//
//        System.out.println("\nNo se encontró ninguna reserva con la ID y el apellido especificados.");
//    }




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



    public void setReservas(HashMap<Integer, Reserva> reservas) {
        this.reservas = reservas;
    }
}
