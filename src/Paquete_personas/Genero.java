package Paquete_personas;

import Paquetes_vuelos.Destinos;

public enum Genero {
    FEMENINO(1), MASCULINO(2), OTROS(3);

    private final int codigo;

    Genero(int codigo) {
        this.codigo = codigo;
    }


    public static Genero getByCodigo(int codigo) {
        for (Genero genero : Genero.values()) {
            if (genero.getCodigo()== codigo) {
                return genero;
            }
        }
        return null;
    }

    public int getCodigo() {
        return codigo;
    }
}
