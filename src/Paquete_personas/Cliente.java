package Paquete_personas;

import java.time.LocalDate;

public class Cliente extends Persona{

    private Integer pasaporte;
    private LocalDate nacimiento; // deberiamos poder calcular en base a al fecha de nacimiento
    private String genero; // enum?
    private long numTelefono;


    public Cliente(String nombre, String apellido, String email, Integer pasaporte, LocalDate nacimiento, String genero, long numTelefono) {
        super(nombre, apellido, email);
        this.pasaporte = pasaporte;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPasaporte= " + pasaporte +
                "\nFecha de nacimiento= "+ nacimiento
                +"\nGenero= " +genero
                +"\n----------------";
    }
}
