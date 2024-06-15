package Paquete_personas;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;

@JsonTypeName("Admin")
public class Admin extends Empleado implements Serializable {

    public Admin(String nombre, String apellido, String email, String contra) {
        super(nombre, apellido, email, contra);
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{}";
    }


}
