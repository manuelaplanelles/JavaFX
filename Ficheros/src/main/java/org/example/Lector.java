package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Lector {

    static Scanner teclado = new Scanner(System.in);


    static void main(String[] args) throws FileNotFoundException {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("Ficheros/src/main/resources/archivos/aprobados/Nombre2.txt"));

            String linea;

            while ((linea = lector.readLine()) != null){

                String datos[] = linea.split(";");

                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String profesion = datos[2];

                System.out.println("Persona con nombre: " + nombre + " tiene " + edad + " y es " + profesion);

            }

            lector.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        buscador();
//        verTexto();

    }

    public static void buscador(){
        int contador = 0;

        System.out.printf("Que palabra quieers buscar:");
        String palabraBuscar = teclado.nextLine();

        try {
            BufferedReader lector = new BufferedReader(new FileReader("Ficheros/src/main/resources/archivos/aprobados/Nombre2.txt"));
            String linea;

            while ((linea = lector.readLine()) != null){

                String palabrasSeparadas [] = linea.split(" ");
                System.out.println(Arrays.toString(palabrasSeparadas));


                for (int i = 0; i < palabrasSeparadas.length; i++) {
                    if (palabrasSeparadas[i].equals(palabraBuscar)){
                        contador++;
                    }
                }
            }

            lector.close();
            System.out.println("");
            System.out.println("Se ha encontrado la palabra: " + contador + " veces");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void verTexto() throws FileNotFoundException {

        try{
            Scanner lector = new Scanner(new File("Ficheros/src/main/resources/archivos/aprobados/Nombre2.txt"));
            while (lector.hasNextLine()){
                String linea = lector.nextLine();
                System.out.println(linea);
            }
            lector.close();

        } catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}