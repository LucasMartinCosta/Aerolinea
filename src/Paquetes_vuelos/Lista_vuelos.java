package Paquetes_vuelos;

import java.util.*;
import java.util.function.Consumer;

public class Lista_vuelos implements Iterable<Vuelo> {  //en esta clase estan todos los metodos para manejar la lista de vuelos
    HashSet<Vuelo> lista_vuelos = new HashSet<>();

    public void agregarvueloslista(Vuelo a)
    {
        lista_vuelos.add(a);
    }

    public HashSet<Vuelo> getLista_vuelos() {
        return lista_vuelos;
    }

    public void setLista_vuelos(HashSet<Vuelo> lista_vuelos) {
        this.lista_vuelos = lista_vuelos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lista_vuelos that)) return false;
        return Objects.equals(lista_vuelos, that.lista_vuelos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lista_vuelos);
    }

    public void mostrar_paquetes_vuelos()
    {
        for(Vuelo a: lista_vuelos)
        {
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        return "Lista_vuelos{" +
                "lista_vuelos=" + lista_vuelos +
                '}';
    }

    @Override
    public Iterator<Vuelo> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Vuelo> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Vuelo> spliterator() {
        return Iterable.super.spliterator();
    }
}
