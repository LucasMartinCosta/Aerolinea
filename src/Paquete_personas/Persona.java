package Paquete_personas;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate nacimiento; // deberiamos poder calcular en base a al fecha de nacimiento
    private String genero; // enum?
    private long numTelefono;


    // constructor para usar cuando queres iniciar sesion? faltaria la contrasenia ?
    public Persona(String nombre,String email ) {
        this.nombre = nombre;
        this.email = email;

    }

    // este costructor podemos usarlo para cuando queremos comprar un vuelo
    public Persona(String nombre, String apellido,  LocalDate nacimiento, String genero, long numTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;

        this.nacimiento = nacimiento;
        this.genero = genero;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }

//equals para que no se repitan los email

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(email, persona.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() {
        return "\n---------"+
                "\n" + nombre  +
                "\nEmail= " + email +"\n---------";

    }
}
