package org.example.javaxf;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.lang.classfile.Label;
import java.sql.Connection;
import java.time.LocalDate;

public class EstudiantesController {
    static Connection db;

    public TableView<Estudiante> estudianteTableView;
    public TableColumn<Estudiante, Integer> niaTableColum;
    public TableColumn<Estudiante, String> nombreTableColum;
    public TableColumn<Estudiante, LocalDate> fechaTableColum;
    public Label mensajeLabel;
    public TextField introNIATextField;
    public TextField introNomTextField;
    public DatePicker fechaDatePicker;
    public Button insertarButton;
    public Button guardarButton;

    @FXML
    public void initialize(){

        db = DatosEstudiantes.conexion();

        niaTableColum.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getNia()).asObject());
        nombreTableColum.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        fechaTableColum.setCellValueFactory(datos-> new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));

       estudianteTableView.setItems(DatosEstudiantes.consulta(db));

    }



    public void editarButton() {
        Estudiante estudiante = estudianteTableView.getSelectionModel().getSelectedItem();
        if (estudiante==null){
            mensajeLabel.setText("No hay nadie seleccionado.");
        }else{
            insertarButton.setDisable(true); //true:habilitar o false:deshabilitar
            guardarButton.setDisable(false);

            introNIATextField.setText(estudiante.getNia().toString());
            introNomTextField.setText(estudiante.getNombre().toString());
            fechaDatePicker.setValue(estudiante.getFecha_nacimiento());
        }
    }

    public void eliminarButton() {
        Estudiante estudiante = estudianteTableView.getSelectionModel().getSelectedItem();
        if (estudiante==null){
            mensajeLabel.setText("No hay nadie seleccionado.");
        }else{
            DatosEstudiantes.eliminar(db,estudiante);
            mensajeLabel.setText("Estudiante eliminado.");
            estudianteTableView.setItems(DatosEstudiantes.consulta(db));
        }
    }

    public void insertarButton() {
        introNIATextField.getText();
        introNomTextField.getText();
        Integer nomre =
    }

    public void guardarButton() {
        Integer nia = Integer.parseInt(introNIATextField.getText());
        String nombre = introNomTextField.getText();
        LocalDate fecha = fechaDatePicker.getValue();
        DatosEstudiantes.guardar(db, new Estudiante(nia, nombre, fecha));
        insertarButton.setDisable(false);
        guardarButton.setDisable(true);
        mensajeLabel.setText("Estudiante modificado.");
        introNIATextField.clear();
        introNomTextField.clear();
        fechaDatePicker = null;
    }
}
