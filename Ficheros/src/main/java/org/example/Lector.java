package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Lector {
    public static void main(String[] args) {
        int veces = buscarPalabra();
        System.out.println(veces);

        try {
            Scanner lector =  new Scanner(new File("src/main/resources/archivos/Nombre2.txt"));


            while (lector.hasNext()){
                String linea = lector.nextLine();

                String datos [] = linea.split(";");

                String nombre = datos [0];
                int edad = Integer.parseInt(datos[1]);
                String profesion = datos [2];

                System.out.println("Persona con nombre " + nombre + " con edad "+edad+" profesion "+profesion);
            }
            lector.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int buscarPalabra() {
        int contador = 0;

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/archivos/Nombre1.txt"));
            String linea;
            String palabraBuscada = "libero";

            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.split(" ");

                for (int i = 0; i < palabras.length; i++) {
                    if (palabras[i].equalsIgnoreCase(palabraBuscada)) {
                        contador++;
                    }
                }
            }

            lector.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contador;
    }

}