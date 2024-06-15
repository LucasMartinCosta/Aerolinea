package Paquete_personas;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;

@JsonTypeName("Admin")
public class Admin extends Empleado implements Serializable {

    public Admin(String nombre, String apellido, String email, String contra,Genero genero) {
        super(nombre, apellido, email, contra,genero);
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{}";
    }


}
