package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritor {
    static void main() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/archivos/aprobados/Nombre3.txt"));

            escritor.write("Hola, mundo!");
            escritor.newLine();
            escritor.write("Esto se guarda en el archivo.");

            escritor.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void actividad8 (){

    }
}