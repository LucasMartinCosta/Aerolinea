package Paquete_personas;

import java.io.Serializable;

public class Admin extends Empleado implements Serializable {

    public Admin(String nombre, String apellido, String email, String contra) {
        super(nombre, apellido, email, contra);
    }

    public Admin() {
    }


}
