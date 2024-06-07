package Tipos_listas;

import Aviones.Avion;

import java.util.ArrayList;

public class Lista_aviones {

    ArrayList<Avion> lista_aviones = new ArrayList<>();

    public void agregar_aviones_lista(Avion dato)
    {
        lista_aviones.add(dato);
    }

    public void mostrar_lista_aviones()
    {
        for(Avion e : lista_aviones)
        {
            System.out.println(e);
        }
    }

    public ArrayList<Avion> getLista_aviones() {
        return lista_aviones;
    }

    public void setLista_aviones(ArrayList<Avion> lista_aviones) {
        this.lista_aviones = lista_aviones;
    }
}
