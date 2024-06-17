package Menus;

public class VueloNoExisteExc extends RuntimeException{
    public VueloNoExisteExc(String message) {
        super("El codigo de vuelo: " + message + " no existe en el sistema.");
    }
}
