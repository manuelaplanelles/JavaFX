package org.example;

import java.io.*;

public class NasaApp {
    public static void main(String[] args) {

        Nave artemis = new Nave("Artemis II", 20000,100000);

        try {
            //serializar
            ObjectOutputStream nave = new ObjectOutputStream(new FileOutputStream("artemis_nulo.set"));

            nave.writeObject(artemis);
            nave.close();

            //deserialización
            ObjectInputStream deserializo = new ObjectInputStream(new FileInputStream("artemis_nulo.set"));
            Nave nave_sorpresa = (Nave) deserializo.readObject();

            System.out.println(nave_sorpresa.getNombre()+" "+nave_sorpresa.getPeso()+" "+nave_sorpresa.getVelocidad());

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }


    }
}
