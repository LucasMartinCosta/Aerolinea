package Tipos_listas;

import Aerolinea.Reserva;

import java.util.HashMap;
import java.util.Map;

public class Lista_reservas {
    HashMap<Integer, Reserva> lista_reservas = new HashMap<>();

    public void agregar_reservas(Reserva dato, Integer id)
    {
        lista_reservas.put(id,dato);
    }

    public void mostrar_reservas()
    {
        for (Map.Entry<Integer,Reserva >entry: lista_reservas.entrySet() )
        {
            Reserva a = entry.getValue();
            Integer id= entry.getKey();
            System.out.println(id+"->"+a);
        }
    }
}
