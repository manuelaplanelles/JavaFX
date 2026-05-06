package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros {
    public static void main(String[] args) {

        crearArchivo();

        File archivo = new File("src/main/resources/aprobados.txt"); //se ha creado un objeto, no es un archivo.

        try {
            if( archivo.createNewFile()){                       // con esta función si que creamos el archivo
                System.out.println("Archivo creado");
            }else{
                System.out.println("No se ha creado el archivo");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println(archivo.getName());
        System.out.println(archivo.length());
        System.out.println(archivo.getAbsolutePath());

        if(archivo.exists()){
            archivo.delete();
        }

        File carpeta = new File("src/main/resources/archivos");

        if (carpeta.mkdir()){
            System.out.println("Carpeta creada.");
        }else{
            System.out.println("La carpeta no creada.");
        }

        String nombre_ficheros[] = carpeta.list();
        for(String nombrecito : nombre_ficheros){
            System.out.println(nombrecito);
        }
        File ficheros[] = carpeta.listFiles();
        for(File ficherito : ficheros){
            System.out.println(ficherito.getName() +" con tamaño "+ficherito.length());
        }
    }

    public static void crearArchivo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuántos archivos quieres crear?");
        int numArchivos = teclado.nextInt();
        teclado.nextLine();

        System.out.println("¿En qué carpeta quieres crearlos?");
        String rutaCarpeta = teclado.nextLine();

        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
            System.out.println("Carpeta creada: " + rutaCarpeta);
        }

        for (int i = 1; i <= numArchivos; i++) {
            File archivo = new File(carpeta, "nombre(" + i + ").txt");

            try {
                if (archivo.createNewFile()) {
                    System.out.println("Creado: " + archivo.getName());
                } else {
                    System.out.println("Ya existe: " + archivo.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
