package Paquete_personas;

import java.time.LocalDate;

public class Cliente extends Persona{

    private Integer pasaporte;
    private LocalDate nacimiento; // deberiamos poder calcular en base a al fecha de nacimiento

    private long numTelefono;

    public Cliente(String nombre, String apellido, String email, Genero genero, Integer pasaporte, LocalDate nacimiento, long numTelefono) {
        super(nombre, apellido, email, genero);
        this.pasaporte = pasaporte;
        this.nacimiento = nacimiento;
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPasaporte= " + pasaporte +
                "\nFecha de nacimiento= "+ nacimiento

                +"\n----------------";
    }
}
