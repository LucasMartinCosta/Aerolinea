package Paquetes_vuelos;

import java.util.*;
import java.util.function.Consumer;

//en esta clase estan todos los metodos para manejar la lista de vuelos
//Implementa iterable para poder hacer que la lista_vuelos itere.

public class Lista_vuelos implements Iterable<Vuelo> {
    HashSet<Vuelo> lista_vuelos = new HashSet<>();

    public void agregarvueloslista(Vuelo a)
    {
        lista_vuelos.add(a);
    }

    public Vuelo buscarVuelo(String codigo)
    {
        Vuelo buscado = null;

        for (Vuelo dato:lista_vuelos)
        {
            if (dato.getCodigoVuelo().equals(codigo))
            {
                buscado=dato;
            }
        }

        return buscado;
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
        return lista_vuelos.iterator();
    }

    @Override
    public void forEach(Consumer<? super Vuelo> action) {
        lista_vuelos.forEach(action);
    }

    @Override
    public Spliterator<Vuelo> spliterator() {
        return lista_vuelos.spliterator();
    }
}
