package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GsonEjemplo {
    public static void main(String[] args) {

//        Gson gson = new Gson();
//como objeto
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        PersonaJSON persona = new PersonaJSON("Luis", 25, Arrays.asList("Java", "Python"));
        String json = gson.toJson(persona);
        System.out.println("JSON: " + json);

        try (FileWriter writer = new FileWriter("JSON/src/main/resources/persona.json")) {
            gson.toJson(persona, writer);
            System.out.println("JSON objeto guardado en persona.json");
        } catch (Exception e) { e.printStackTrace(); }

        try {
            FileReader reader = new FileReader("JSON/src/main/resources/persona.json");
            PersonaJSON persona2 = gson.fromJson(reader, PersonaJSON.class);
            System.out.println("Nombre: " + persona2.getNombre());
            System.out.println("Edad: " + persona2.getEdad());
            System.out.println("Lenguajes: " + persona2.getLenguajes());
        } catch (Exception e) {
            e.printStackTrace();
        }

// como lista
        ArrayList<PersonaJSON> listaPersonas = new ArrayList<>(Arrays.asList(new PersonaJSON("Luis", 25, Arrays.asList("Java", "Python")), new PersonaJSON("Patricia", 40, Arrays.asList("Java", "MongoDB"))));
        String json2 = gson.toJson(listaPersonas);
        System.out.println("JSON: " + json2);

        try (FileWriter writer2 = new FileWriter("JSON/src/main/resources/personas.json")) {
            gson.toJson(listaPersonas, writer2);
            System.out.println("JSON lista guardada en persona.json");
        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        try {
            FileReader reader2 = new FileReader("JSON/src/main/resources/personas.json");
            PersonaJSON[] personas = gson.fromJson(reader2, PersonaJSON[].class);
            List<PersonaJSON> lista = Arrays.asList(personas);

            for (PersonaJSON person : listaPersonas) {
                System.out.println("Nombre: " + person.getNombre());
                System.out.println("Edad: " + person.getEdad());
                System.out.println("Lenguajes: " + person.getLenguajes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
