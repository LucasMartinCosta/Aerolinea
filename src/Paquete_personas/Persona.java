package Paquete_personas;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellido;
    private String email;




    // constructor para usar cuando queres iniciar sesion? faltaria la contrasenia ?
    public Persona(String nombre, String apellido,String email ) {
        this.nombre = nombre;
        this.email = email;


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
