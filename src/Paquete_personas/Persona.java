package Paquete_personas;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Cliente.class, name = "cliente"),
        @JsonSubTypes.Type(value = Empleado.class, name = "empleado"),
        @JsonSubTypes.Type(value = Admin.class, name = "admin")
})

public class Persona implements Comparable<Persona>, Serializable {
    private String nombre;
    private String apellido;
    private String email;
    private String contra;


    // este constructor lo podemos usar a la hora de comprar vuelos cuando tenes que completar datos
    public Persona(String nombre, String apellido,String email, String contra ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contra = contra;
    }


    public Persona() {
    }

    //constructor que usamos para generar USUARIOS!
    public Persona(String email, String contra){
        this.email = email;
        this.contra = contra;
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

    public String getContra() {
        return contra;
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
    @Override
    public int compareTo(Persona o) {
        return this.apellido.compareTo(o.apellido);
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
