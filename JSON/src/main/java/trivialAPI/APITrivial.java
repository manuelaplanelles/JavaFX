package trivialAPI;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APITrivial {
    public static void main(String[] args) {

        try {
            String apiUrl = "https://opentdb.com/api.php?amount=1&category=18";

            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            in.close();

            Gson gson = new Gson();
            Trivial trivia = gson.fromJson(json.toString(), Trivial.class);

            System.out.println("Pregunta:");
            System.out.println(trivia.question);
            System.out.println("Respuesta correcta:");
            System.out.println(trivia.correct_answer);

        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }
}
