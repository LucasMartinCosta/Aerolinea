package Tipos_listas;

import Aerolinea.Reserva;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Lista_reservas implements Serializable {
    HashMap<Integer, Reserva> lista_reservas = new HashMap<>();
    public Lista_reservas() {
    }

    public HashMap<Integer, Reserva> getLista_reservas() {
        return lista_reservas;
    }

    public void setLista_reservas(HashMap<Integer, Reserva> lista_reservas) {
        this.lista_reservas = lista_reservas;
    }

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
