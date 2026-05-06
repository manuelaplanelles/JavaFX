package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ficheros {
    static Scanner teclado = new Scanner(System.in);
    static void main() {

//        File archivo = new File("src/main/resources/aprobados.txt"); //se ha creado un objeto, no es un archivo.
//        try {
//            if (archivo.createNewFile()){                             // con esta función si que creamos el archivo
//                System.out.printf("Archivo creado");
//            } else {
//                System.out.printf("No se ha creado el archivo");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(archivo.length());
//        System.out.println(archivo.getAbsolutePath());
//        System.out.printf(archivo.getName());
//        if (archivo.exists()){
//            archivo.delete();
//        }
//
        File carpeta = new File("src/main/resources/archivos/aprobados");
//        if (carpeta.mkdir()){
//            System.out.printf("Carpeta creada.");
//        }else {
//            System.out.printf("No se ha creado la carpeta.");
//        }
//        crearArchivo();

        String nombre_fichero [] = carpeta.list();
        for (String nombrecito : nombre_fichero){
            System.out.printf(nombrecito);
        }

        File ficheros[] = carpeta.listFiles();
        for (File ficherito : ficheros){
            System.out.printf(ficherito.getName() + " con tamaño " + ficherito.length());
        }
    }

    public static void crearArchivo(){
        System.out.printf("¿Cuántos archivos quieres crear?");
        int numero = teclado.nextInt();
        System.out.printf("¿En qué carpeta quieres crearlos?");
        String donde = teclado.next();

        int contador = 0;

        for (int i = 0; i < numero; i++) {
            System.out.printf("Nombre " + contador + ". txt");

            File archivo = new File(donde + "/Nombre" + contador);
            try {
                if (archivo.createNewFile()){
                    System.out.printf("Archivo creado");
                } else {
                    System.out.printf("No se ha creado el archivo");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            contador++;

        }
    }
    public static void leerArchivo(){


        try {
            BufferedReader archivo1 = new BufferedReader(new FileReader("src/main/resources/archivos/archivo1.txt"));
            BufferedReader archivo2 = new BufferedReader(new FileReader("src/main/resources/archivos/archivo2.txt"));
            BufferedWriter resultado = new BufferedWriter(new FileWriter("src/main/resources/archivos/resultado.txt"));

            String linea = "";
            Queue<String> cola1 = new LinkedList<>();
            while ((linea = archivo1.readLine()) != null){

                String palabritas[] = linea.split(" ");
                for (String palabra : palabritas){
                }
            }
            Queue<String> cola2 = new LinkedList<>();

            while ((linea = archivo1.readLine()) != null){
                String palabritas[] = linea.split(" ");
                for (String palabra : palabritas){
                }
            }

            while (cola1.isEmpty() || cola2.isEmpty()){
                resultado.write(cola1.poll() + " " + cola2.poll() + " ");
            }

            if (cola1.isEmpty()){
                while (!cola2.isEmpty()){
                    resultado.write(cola2.poll());
                }
            }else {
                while (!cola1.isEmpty()){
                    resultado.write(cola1.poll());
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}