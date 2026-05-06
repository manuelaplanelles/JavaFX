package org.example.demofx;

public class Contador {
    private int contador;

    public Contador(){
        contador=0;
    }
    public void contar(){
        contador++;
    }
    public int getContador(){
        return contador;
    }
    public void setContador(int valor){
       contador=valor;
    }
}
