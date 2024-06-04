package Paquetes_vuelos;

import java.util.ArrayList;
import java.util.Objects;

public class Lista_vuelos {
    ArrayList<Vuelo> lista_vuelos = new ArrayList<>();

    public void agregarvueloslista(Vuelo a)
    {
        lista_vuelos.add(a);
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
        int i=0;
        for(i=0;i<lista_vuelos.size();i++)
        {
            System.out.println(lista_vuelos.get(i));
        }

    }
}
