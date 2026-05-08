package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PruebaJson {

    public static void main(String[] args) {
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<Pais> listaPaises = new ArrayList<>(Arrays.asList(
                new Pais("Nueva Zelanda", "Oceania", 1500000, Arrays.asList("Nuevocelandes","Ingles","Espanol")),
                new Pais("Mongolia", "Asia", 25400, Arrays.asList("Mongolia","Ingles","Espanol"))
        ));

        Pais espanya = new Pais ("España", "Europa", 50000000, Arrays.asList("Vasco","Catalan","Espanol"));


        System.out.println(listaPaises);

        String pais_json = json.toJson(listaPaises);
        System.out.println(pais_json);

        try {
            FileWriter escribir = new FileWriter("C:/Users/manue/Documents/JavaFX/Ficheros/src/main/resources/paises.json");
            json.toJson(listaPaises,escribir);

            escribir.close();

            FileWriter escribir_esp = new FileWriter("C:/Users/manue/Documents/JavaFX/Ficheros/src/main/resources/espanya.json");
            json.toJson(espanya,escribir_esp);

            escribir_esp.close();


        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }


        try {
            FileReader leer = new FileReader("C:/Users/manue/Documents/JavaFX/Ficheros/src/main/resources/espanya.json");
            Pais pais = json.fromJson(leer,Pais.class);                             //el nombre de la clase que has creado el json

            leer.close();
            System.out.println(pais.getNombre());

            FileReader leer_lista = new FileReader("C:/Users/manue/Documents/JavaFX/Ficheros/src/main/resources/paises.json");
            Pais paises[] = json.fromJson(leer_lista,Pais[].class);
            ArrayList<Pais> lista = new ArrayList<>(Arrays.asList(paises));

            leer_lista.close();
            for(Pais paisito : lista){
                System.out.println(paisito.getNombre());
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
