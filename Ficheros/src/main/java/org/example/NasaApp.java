package org.example;

import java.io.*;
import java.util.ArrayList;

public class NasaApp {
    public static void main(String[] args) {
        ArrayList<Nave> listaNaves = new ArrayList<>();
        listaNaves.add(new Nave("Artemis II", 20000, 100000));
        listaNaves.add(new Nave("Discovery", 15000, 85000));
        listaNaves.add(new Nave("Voyager", 8000, 60000));

        Nave artemis = new Nave("Artemis II", 20000,100000);

        try {
            //serializar
            ObjectOutputStream nave = new ObjectOutputStream(new FileOutputStream("artemis_nulo.set"));

            nave.writeObject(artemis);
            nave.close();

            //deserialización
            ObjectInputStream deserializo = new ObjectInputStream(new FileInputStream("artemis_nulo.set"));
            ArrayList<Nave> listaRecuperada = (ArrayList<Nave>) deserializo.readObject();
            Nave nave_sorpresa = (Nave) deserializo.readObject();

            for(Nave nave1 : listaRecuperada){
                System.out.println(nave_sorpresa.getNombre()+" "+nave_sorpresa.getPeso()+" "+nave_sorpresa.getVelocidad());
            }


            nave.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }


    }
}
