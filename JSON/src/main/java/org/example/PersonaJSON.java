package org.example;

import java.util.ArrayList;
import java.util.List;

public class PersonaJSON {
    private String nombre;
    private int edad;
    private List<String> lenguajes;

    public PersonaJSON() {}

    public PersonaJSON(String nombre, int edad, List<String> lenguajes) {
        this.nombre = nombre;
        this.edad = edad;
        this.lenguajes = new ArrayList<>(lenguajes);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    @Override
    public String toString() {
        return "PersonaJSON{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", lenguajes=" + lenguajes +
                '}';
    }
}
