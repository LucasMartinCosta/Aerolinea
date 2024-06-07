package Tipos_listas;

import Paquete_personas.Persona;

import java.util.TreeSet;

public class Lista_Personas {
    TreeSet<Persona> lista_personas = new TreeSet<>();

    public void agregar_personas(Persona dato)
    {
        lista_personas.add(dato);
    }

    public void mostrar_lista_personas()
    {
        for(Persona a: lista_personas)
        {
            System.out.println(a);
        }
    }

    public TreeSet<Persona> getLista_personas() {
        return lista_personas;
    }

    public void setLista_personas(TreeSet<Persona> lista_personas) {
        this.lista_personas = lista_personas;
    }
}
