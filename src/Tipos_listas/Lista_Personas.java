package Tipos_listas;

import Paquete_personas.Persona;

import java.io.Serializable;
import java.util.TreeSet;

public class Lista_Personas implements Serializable {
    TreeSet<Persona> lista_personas = new TreeSet<>();

    public void agregar_personas(Persona dato)
    {
        lista_personas.add(dato);
    }

    public Lista_Personas() {
    }

    public void mostrar_lista_personas()
    {
        for(Persona a: lista_personas)
        {
            System.out.println(a);
        }
    }

//    public Persona buscarPersona (String apellido, String contra)
//    {
//        for (Persona persona:lista_personas)
//        {
//            if (persona.getApellido().equals(apellido) && persona.getContra().equals(contra))
//            {
//                return persona;
//            }
//        }
//        return null;
//    }

    public TreeSet<Persona> getLista_personas() {
        return lista_personas;
    }

    public void setLista_personas(TreeSet<Persona> lista_personas) {
        this.lista_personas = lista_personas;
    }


}
