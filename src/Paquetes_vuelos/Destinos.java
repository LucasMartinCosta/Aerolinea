package Paquetes_vuelos;

import java.util.Scanner;

public enum Destinos {
    BUENOSAIRES,
    MENDOZA,
    CORDOBA,
    RIONEGRO,
    MISIONES,
    MARDELPLATA,
    SANTAFE,
    CHACO ,
    TIERRADELFUEGO,
    SANTACRUZ,
    SALTA,
    JUJUY;


    Destinos() {
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarDestinos() {
        System.out.println("Destinos disponibles:");
        for (Destinos destino : Destinos.values()) {
            System.out.println(destino);
        }
    }

    public static Destinos elegirDestino(String tipo) {
        Destinos destinoElegido = null;
        boolean destinoValido = false;

        while (!destinoValido) {
            System.out.println("Ingrese el destino de " + tipo + ": ");
            String destinoInput = scanner.nextLine().toUpperCase();

            try {
                destinoElegido = Destinos.valueOf(destinoInput);
                destinoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Destino no válido. Por favor, intente de nuevo.");
            }
        }
        return destinoElegido;
    }

    public static void elegirDestinos(Vuelo vuelo) {
        mostrarDestinos();

        //System.out.println("Elija su destino de origen:");
        Destinos origen = elegirDestino("origen");

        Destinos destino = null;
        while (destino == null || destino == origen) {
            //System.out.println("Elija su destino de llegada:");
            destino = elegirDestino("llegada");

            if (destino == origen) {
                System.out.println("El destino de llegada no puede ser el mismo que el de origen. Por favor, elija otro destino.");
            }
        }

        System.out.println("Origen elegido: " + origen);
        System.out.println("Destino de llegada elegido: " + destino);

        vuelo.setOrigen(origen);
        vuelo.setDestino(destino);
    }




}
