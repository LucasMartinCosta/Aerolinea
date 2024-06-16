package Paquete_personas;

import Aerolinea.Reserva;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Console;
//import java.lang.classfile.Attribute;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@JsonTypeName("Cliente")
public class Cliente extends Persona implements Serializable {
    private Integer pasaporte;
    private int edad;
    private long numTelefono;
    private String contrasenia;
    private HashMap<Integer, Reserva> reservas; //hashMap con reservas de cada cliente

    private Scanner scan = new Scanner(System.in);

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String contra,Genero genero) {
        super(nombre, apellido, email, contra,genero);
    }



    public Cliente(String nombre, String apellido, String email, String contra,Genero genero, Integer pasaporte, int edad, long numTelefono) {
        super(nombre, apellido, email, contra,genero);
        this.pasaporte = pasaporte;
        this.edad = edad;
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

        Vuelo buscado=listaVuelos.buscarVuelo(codigo);
        //funcion de buscar vuelo con el codigo leido
        return buscado;
    }

    public Double comprarAsientos (Vuelo dato)
    {
        Integer continuar = 1;
        double totalCompra = 0.;

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
    public void mostrarEstadoDelVuelo(Integer idReserva) {
        Reserva reserva = reservas.get(idReserva);
        if (reserva != null) {
            reserva.mostrarEstadoDeTodosLosVuelos();
        } else {
            throw new NoSuchElementException("\nNo se encontro ninguna reserva con el ID proporcionado.");
        }
    }

    public void mostrarReservas(){
        for (Map.Entry<Integer, Reserva> entry : reservas.entrySet()) {
            Reserva reserva = entry.getValue();
        }

    }


    public void mostrarPasajes() {
        if (reservas.isEmpty()) {
            System.out.println("\nNo hay reservas registradas para este cliente.");
            return;
        }

        for (Reserva reserva : reservas.values()) {
            reserva.mostrarPasaje();
        }
    }



    public void eliminarReserva(Integer id) {  //Elimina una reserva pasandole el codigo.

        boolean encontrada = false;
            Iterator<Map.Entry<Integer, Reserva>> iterator = reservas.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Reserva> entry = iterator.next();
                if (entry.getKey().equals(id)) {

                    iterator.remove();
                    System.out.println("\nReserva eliminada con éxito.");
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                System.out.println("\nNo se encontró ninguna reserva con el código especificado. Vuelve a intentarlo.");
            }

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

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public HashMap<Integer, Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(HashMap<Integer, Reserva> reservas) {
        this.reservas = reservas;
    }
}
