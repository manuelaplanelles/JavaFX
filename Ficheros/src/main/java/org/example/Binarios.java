package org.example;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binarios {
    public static void main(String[]arg) {
        try {
            DataOutputStream binario= new DataOutputStream(new FileOutputStream("fichero_binario.bin"));
            binario.writeBoolean(true);
            binario.writeChar('x');
            binario.writeInt(11);
            binario.writeUTF("holaaaa");

            binario.close();

        } catch (IOException e) {
            System.out.println(e.getStackTrace());          //para que aparezca el error
        }
    }
}
