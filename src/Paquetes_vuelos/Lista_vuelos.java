package Paquetes_vuelos;

import java.util.ArrayList;

public class Lista_vuelos {
    ArrayList<Vuelo> lista_vuelos = new ArrayList<>();

    public void agregarvueloslista(Vuelo a)
    {
        lista_vuelos.add(a);
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
