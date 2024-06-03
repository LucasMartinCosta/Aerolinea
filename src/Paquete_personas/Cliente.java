package Paquete_personas;

import Paquetes_vuelos.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona{

    private Integer pasaporte;
    private LocalDate nacimiento;
    private int edad;
    private long numTelefono;
    private ArrayList<Vuelo> vuelos_comprados = new ArrayList<>();

    public Cliente(String nombre, String apellido, String email, Integer pasaporte, LocalDate nacimiento, int edad,long numTelefono) {
        super(nombre, apellido, email);
        this.pasaporte = pasaporte;
        this.nacimiento = nacimiento;
        this.edad = edad ;
        this.numTelefono = numTelefono;
    }


    @Override
    public String toString() {
        return super.toString() +
                "\nPasaporte= " + pasaporte +
                "\nFecha de nacimiento= "+ nacimiento

                +"\n----------------";
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
}
