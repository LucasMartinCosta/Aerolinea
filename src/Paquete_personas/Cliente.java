package Paquete_personas;

import Aerolinea.Reserva;
import Paquetes_vuelos.Lista_vuelos;
import Paquetes_vuelos.Vuelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import paquete_archivos.Manejo_archivos;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    //@JsonManagedReference
   @JsonIgnore
    private HashMap<Integer, Reserva> reservas = new HashMap<>(); //hashMap con reservas de cada cliente

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
        this.contrasenia=contra;
    }

    public void agregarReserva (Reserva reserva, Manejo_archivos archivo)
    {
        reservas.put(reserva.getId(), reserva);
        archivo.getListaReservas().put(reserva.getId(), reserva);
    }

    public void cargarReservasCliente (Manejo_archivos archivos)
    {
        for (Reserva dato:archivos.getListaReservas().values())
        {
            if(dato.getCliente()!=null && dato.getCliente().equals(this))
            {
                reservas.put(dato.getId(), dato);
            }
        }

    }

    public Vuelo elegirVueloAComprar (Lista_vuelos listaVuelos)
    {
        for (Vuelo vuelo:listaVuelos)
        {
            System.out.println(" ------ ");
            System.out.println("\n CODIGO: " + vuelo.getCodigoVuelo() +  //Capaz que se pueden agregar las fechas
                    "\n ORIGEN: "+vuelo.getOrigen() +
                    "\n DESTINO: "+vuelo.getDestino() +
                    "\n FECHA SALIDA: "+vuelo.getFechaIda());
        }
        System.out.println(" Ingrese el codigo del vuelo a comprar");
        String codigo = scan.nextLine();


        Vuelo buscado=listaVuelos.buscarVuelo(codigo);
        //System.out.println("buscado = " + buscado);
        //funcion de buscar vuelo con el codigo leido
        return buscado;
    }

    public Double comprarAsientos (Vuelo dato, Reserva nueva)
    {
        double totalCompra = 0.;


            dato.getAvion().mostrarAsientos();
            int flag=0;
            char letra='a';
            System.out.println("Ingrese la fila del asiento");
            int filaElegida =scan.nextInt();
            scan.nextLine();
            while (flag==0)
            {
                System.out.println("Ingrese la letra del asiento");
                String input = scan.next();
                if (input.length() == 1) {
                    letra = Character.toUpperCase(input.charAt(0));
                    if(dato.getAvion().comprarAsiento(this,filaElegida,letra))
                    {
                        flag=1;
                    }
                } else {
                    System.out.println("Por favor, ingrese un solo carácter.");
                }
            }

            nueva.setFila(filaElegida);
            nueva.setLetra(letra);



            totalCompra=totalCompra+dato.getPrecioVuelo();

            scan.nextLine();

        return totalCompra;
    }
    public void mostrarEstadoDelVuelo(Integer idReserva) {
        Reserva reserva = reservas.get(idReserva);
        if (reserva != null) {
            reserva.mostrarEstadoDeTodosLosVuelos();
        } else {
            throw new NoSuchElementException("\n No se encontro ninguna reserva con el ID proporcionado.");
        }
    }

    public boolean mostrarReservas(){
        if(reservas.isEmpty())
        {
            System.out.println(" El cliente no tiene reservas");
            return false;
        }

        else{
            for (Map.Entry<Integer, Reserva> entry : reservas.entrySet()) {
                Integer clave = entry.getKey();
                Reserva reserva = entry.getValue();
                System.out.println("ID DE RESERVA: " + clave + " INFORMACION: " + reserva.toString());

            }
        }
        return true;
    }


    public void mostrarPasajes() {
        if (reservas.isEmpty()) {
            System.out.println("\n No hay reservas registradas para este cliente.");
        }
        else
        {
            for (Map.Entry<Integer, Reserva> entry : reservas.entrySet()) {
                Reserva reserva = entry.getValue();
                System.out.println(" VUELO: " + reserva.mostrarPasaje());
            }
        }

    }

    public void eliminarReservaCliente(Integer id, Manejo_archivos archivos) {  //Elimina una reserva pasandole el codigo.

        boolean encontrada = false;

        Iterator<Map.Entry<Integer, Reserva>> iterator = reservas.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Reserva> entry = iterator.next();
            if (entry.getKey().equals(id)) {

                iterator.remove();
                System.out.println("\n Reserva eliminada con éxito.");
                archivos.eliminarReservaEstructura(id);
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("\n No se encontró ninguna reserva con el código especificado. Vuelve a intentarlo.");
        }
    }


    @Override
    public String toString() {
        return  super.toString() +
                "\n NUM. PASAPORTE: " + pasaporte +
                "\n EDAD: " + edad +
                "\n TELEFONO: " + numTelefono +
                "\n --------- ";
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