package org.example.demofx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Pantalla2Controller {

    @FXML
    private TextField nombretextfield;

    @FXML
    private TextField edadtextfild;

    @FXML
    private TableView<Persona> personasTableView;

    @FXML
    private TableColumn<Persona,String> nombreTableColumm;

    @FXML
    private TableColumn <Persona, Integer> edadTableColumm;

    @FXML
    public void initialize(){
        nombreTableColumm.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        edadTableColumm.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getEdad()).asObject());

        personasTableView.setItems(PersonasCreadas.getListaPersonas());
    }


    @FXML
    public void volverButton() throws IOException{
        HelloApplication.setRoot("hello-view");
    }

    public void guardarButton() {
        String nombre=nombretextfield.getText();
        Integer edad=Integer.parseInt(edadtextfild.getText());

        Persona persona = new Persona(nombre, edad);
        PersonasCreadas.insertarPerson(persona);
        System.out.println("Persona creada: " + nombre+" - "+edad);
        System.out.println(PersonasCreadas.getListaPersonas());

        nombretextfield.clear();
        edadtextfild.clear();
    }
}


