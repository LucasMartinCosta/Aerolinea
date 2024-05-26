package Paquete_personas;

public class Cliente extends Persona{

    private Integer pasaporte;


    public Cliente(String nombre, String email, Integer pasaporte) {
        super(nombre, email);
        this.pasaporte = pasaporte;
        // fem o masculino?

    }

    @Override
    public String toString() {
        return "\nCliente\n" +
                super.toString()+
                "Pasaporte= " + pasaporte;
    }
}
