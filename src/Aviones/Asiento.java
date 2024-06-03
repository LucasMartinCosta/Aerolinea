package Aviones;

public class Asiento {
    private int fila;
    private char letra;
    private boolean reservado;

    //private Cliente cliente;

    public Asiento(int fila, char letra) {
        this.fila = fila;
        this.letra = letra;
        reservado = false;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isDisponible() {
        return reservado;
    }

    public void setDisponible(boolean disponible) {
        this.reservado = disponible;
    }

    public void reservar ()
    {
        //this.cliente=dato;
        this.reservado=true;
    }

    public void liberar ()
    {
        this.reservado=false;
    }


    @Override
    public String toString() {
        return "Asiento{" +
                "fila=" + fila +
                ", letra=" + letra +
                ", disponible=" + reservado +
                '}';
    }
}
