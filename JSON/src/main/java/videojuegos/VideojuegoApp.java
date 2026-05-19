package videojuegos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class VideojuegoApp {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //a) Crear 3 videojuegos distintos por consola y guardarlos en una colección.
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>(Arrays.asList(
                new Videojuego("Super Mario Bros", "Switch", 49.99, true, Arrays.asList("Plataformas", "Aventura")),
                new Videojuego("Los Sims 4", "PC", 19.99, true, Arrays.asList("Simulación")),
                new Videojuego("Assassin's Creed", "PS5", 29.99, false, Arrays.asList("Acción", "Aventura"))
        ));

        //b) Guardar toda la colección en un archivo JSON (videojuegos.json).
        try (FileWriter writer = new FileWriter("JSON/src/main/resources/videojuegos.json")) {
            gson.toJson(listaVideojuegos, writer);
            System.out.println("JSON guardado en videojuegos.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //c) Leer ese archivo y mostrarlo por pantalla.
        try {
            FileReader reader = new FileReader("JSON/src/main/resources/videojuegos.json");
            String jsonLeido = new com.google.gson.JsonParser().parse(reader).toString();
            System.out.println("Contenido del archivo: " + jsonLeido);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //d) Reconstruir la colección de objetos Java a partir del archivo guardado.
        ArrayList<Videojuego> listaReconstruida = new ArrayList<>();
        try {
            FileReader reader2 = new FileReader("JSON/src/main/resources/videojuegos.json");
            Videojuego[] videojuegos = gson.fromJson(reader2, Videojuego[].class);
            listaReconstruida = new ArrayList<>(Arrays.asList(videojuegos));
            System.out.println("Colección reconstruida con " + listaReconstruida.size() + " videojuegos.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //e) Añadir un videojuego nuevo a la colección.
        listaReconstruida.add(new Videojuego("Zelda Tears of the Kingdom", "Switch", 19.99, true, Arrays.asList("Aventura", "Acción")));
        System.out.println("Videojuego añadido.");

        //f) Mostrar en consola los videojuegos cuyo precio sea menor a 30€.
        System.out.println("Videojuegos con precio menor a 30€:");
        for (Videojuego v : listaReconstruida) {
            if (v.getPrecio() < 30) {
                System.out.println("Nombre: " + v.getNombre());
                System.out.println("Plataforma: " + v.getPlataforma());
                System.out.println("Precio: " + v.getPrecio());
                System.out.println("Disponible: " + v.isDisponible());
                System.out.println("Géneros: " + v.getGeneros());
            }
        }

        //g) Volver a guardar la lista actualizada en el archivo JSON.
        try (FileWriter writer3 = new FileWriter("JSON/src/main/resources/videojuegos.json")) {
            gson.toJson(listaReconstruida, writer3);
            System.out.println("Lista actualizada guardada en videojuegos.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
