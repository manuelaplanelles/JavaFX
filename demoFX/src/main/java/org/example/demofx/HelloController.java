package org.example.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private Button pruebaClickButton;

    @FXML
    private Label contadorLabel;




    static Contador contador = new Contador();
    @FXML
    public void initialize(){

        pruebaClickButton.setOnAction(e ->{
            contador.contar();
            contadorLabel.setText(Integer.toString(contador.getContador()));
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Holaaa!!");
    }

    public void presetClickButton() {
        contador.setContador(0);
        contadorLabel.setText("0");
    }

    public void pantalla2Button() throws IOException {
        HelloApplication.setRoot("Pantalla2");
    }
}
