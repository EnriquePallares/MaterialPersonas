package com.example.android.personasmaterial;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Datos {
    public static ArrayList<Persona> personas = new ArrayList();

    public static void agregar(Persona p){
        personas.add(p);
    }

    public ArrayList<Persona> obtener(){
        return personas;
    }
}
