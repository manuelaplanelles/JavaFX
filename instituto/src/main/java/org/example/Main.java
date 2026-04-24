package org.example;

import java.sql.*;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection bd = conexion();
        System.out.println("Realizando consultas...");
        consulta(bd);
        modificar(bd);
        desconectar(bd);

    }

    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3307/";
        String user = "root";
        String psw = "";
        String bd = "instituto";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectar(Connection conexion){

        System.out.println("Desconectando...");

        try {
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void consulta(Connection conexion){
        String query = "SELECT * FROM estudiante";
        Statement stmt;
        try {
            stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while (resultado.next()){
                Integer nia = resultado.getInt("nia");
                String nombre = resultado.getString("nombre");
                Date fecha = resultado.getDate("fecha_nacimiento");
                System.out.println("Estudiante con nia " + nia
                        + " nombre " + nombre
                        + " fecha de naciemiento " + fecha);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void modificar(Connection conexion){
        String update = "UPDATE estudiante SET nombre = 'Isma' WHERE nombre = 'Ismael'";
        Statement stmt;
        try {
            stmt = conexion.createStatement();
            stmt.executeQuery(update);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}