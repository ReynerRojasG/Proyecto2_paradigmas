/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2_paradigmas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Alvaro Artavia
 */
public class MainFXMLController implements Initializable {

    @FXML
    private Button btn_sec_empleados;
    @FXML
    private Button btn_sec_planillas;
    @FXML
    private TabPane tp_secciones;
    @FXML
    private ToggleGroup tg_tipo;
    @FXML
    private RadioButton rdb_asalariado;
    @FXML
    private RadioButton rdb_porHoras;
    @FXML
    private RadioButton rdb__temporal;
    @FXML
    private RadioButton rdb_comisionista;
    @FXML
    private RadioButton rdb_practicante;
    @FXML
    private Label lbl_salarioMensual;
    @FXML
    private TextField tf_salarioMensual;
    @FXML
    private Label lbl_tarifaHora;
    @FXML
    private TextField tf_tarifaHora;
    @FXML
    private Label lbl_HorasQuincena;
    @FXML
    private TextField tf_horasQuincena;
    @FXML
    private Label lbl_tarifaDiaria;
    @FXML
    private Label lbl_VentasQuincena;
    @FXML
    private TextField tf_ventasQuincena;
    @FXML
    private Label lbl_apoyoQuincena;
    @FXML
    private TextField tf_apoyoQuincena;
    @FXML
    private Label lbl_DiasActivos;
    @FXML
    private TextField tf_diasActivos;
    @FXML
    private Label lbl_base;
    @FXML
    private TextField tf_base;
    @FXML
    private Label lbl_porcentaje;
    @FXML
    private TextField tf_porcentaje;
    @FXML
    private TextField tf_tarifaDiaria;
    @FXML
    private Button btn_cancelEmpleado;
    @FXML
    private Button btn_saveEmpleado1;
    @FXML
    private TextField tf_cedula;
    @FXML
    private TextField tf_nombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ChangeToEmpleados(ActionEvent event) {
        tp_secciones.getSelectionModel().select(0);
    }

    @FXML
    private void ChangeToPlanillas(ActionEvent event) {
        tp_secciones.getSelectionModel().select(1);
    }

    @FXML
    private void enableAsalariadoInfo(ActionEvent event) {
     // Labels
    lbl_tarifaHora.setDisable(true);
    lbl_HorasQuincena.setDisable(true);
    lbl_tarifaDiaria.setDisable(true);
    lbl_VentasQuincena.setDisable(true);
    lbl_apoyoQuincena.setDisable(true);
    lbl_DiasActivos.setDisable(true);
    lbl_base.setDisable(true);
    lbl_porcentaje.setDisable(true);
    lbl_salarioMensual.setDisable(false);

    // TextFields
    tf_tarifaHora.setDisable(true);
    tf_horasQuincena.setDisable(true);
    tf_ventasQuincena.setDisable(true);
    tf_apoyoQuincena.setDisable(true);
    tf_diasActivos.setDisable(true);
    tf_base.setDisable(true);
    tf_porcentaje.setDisable(true);
    tf_salarioMensual.setDisable(false);
    }

    @FXML
    private void enablePorHorasInfo(ActionEvent event) {
         // Labels
    lbl_tarifaHora.setDisable(false);
    lbl_HorasQuincena.setDisable(false);
    lbl_tarifaDiaria.setDisable(true);
    lbl_VentasQuincena.setDisable(true);
    lbl_apoyoQuincena.setDisable(true);
    lbl_DiasActivos.setDisable(true);
    lbl_base.setDisable(true);
    lbl_porcentaje.setDisable(true);
    lbl_salarioMensual.setDisable(true);

    // TextFields
    tf_tarifaHora.setDisable(false);
    tf_horasQuincena.setDisable(false);
    tf_ventasQuincena.setDisable(true);
    tf_apoyoQuincena.setDisable(true);
    tf_diasActivos.setDisable(true);
    tf_base.setDisable(true);
    tf_porcentaje.setDisable(true);
    tf_salarioMensual.setDisable(true);
    }

    @FXML
    private void enableTemporalInfo(ActionEvent event) {
         // Labels
    lbl_tarifaHora.setDisable(true);
    lbl_HorasQuincena.setDisable(true);
    lbl_tarifaDiaria.setDisable(false);
    lbl_VentasQuincena.setDisable(true);
    lbl_apoyoQuincena.setDisable(true);
    lbl_DiasActivos.setDisable(false);
    lbl_base.setDisable(true);
    lbl_porcentaje.setDisable(true);
    lbl_salarioMensual.setDisable(true);

    // TextFields
    tf_tarifaHora.setDisable(true);
    tf_horasQuincena.setDisable(true);
    tf_tarifaDiaria.setDisable(false);
    tf_ventasQuincena.setDisable(true);
    tf_apoyoQuincena.setDisable(true);
    tf_diasActivos.setDisable(false);
    tf_base.setDisable(true);
    tf_porcentaje.setDisable(true);
    tf_salarioMensual.setDisable(true);
    }

    @FXML
    private void enableComisionistaInfo(ActionEvent event) {
            // Labels
    lbl_tarifaHora.setDisable(true);
    lbl_HorasQuincena.setDisable(true);
    lbl_tarifaDiaria.setDisable(true);
    lbl_VentasQuincena.setDisable(false);
    lbl_apoyoQuincena.setDisable(true);
    lbl_DiasActivos.setDisable(true);
    lbl_base.setDisable(false);
    lbl_porcentaje.setDisable(false);
    lbl_salarioMensual.setDisable(true);

    // TextFields
    tf_tarifaHora.setDisable(true);
    tf_horasQuincena.setDisable(true);
    tf_tarifaDiaria.setDisable(true); 
    tf_ventasQuincena.setDisable(false);
    tf_apoyoQuincena.setDisable(true);
    tf_diasActivos.setDisable(true);
    tf_base.setDisable(false);
    tf_porcentaje.setDisable(false);
    tf_salarioMensual.setDisable(true);
    }

    @FXML
    private void enablePracticanteInfo(ActionEvent event) {
           // Labels
    lbl_tarifaHora.setDisable(true);
    lbl_HorasQuincena.setDisable(true);
    lbl_tarifaDiaria.setDisable(true);
    lbl_VentasQuincena.setDisable(true);
    lbl_apoyoQuincena.setDisable(false);
    lbl_DiasActivos.setDisable(true);
    lbl_base.setDisable(true);
    lbl_porcentaje.setDisable(true);
    lbl_salarioMensual.setDisable(true);

    // TextFields
    tf_tarifaHora.setDisable(true);
    tf_horasQuincena.setDisable(true);
    tf_tarifaDiaria.setDisable(true);
    tf_ventasQuincena.setDisable(true);
    tf_apoyoQuincena.setDisable(false);
    tf_diasActivos.setDisable(true);
    tf_base.setDisable(true);
    tf_porcentaje.setDisable(true);
    tf_salarioMensual.setDisable(true);
    }

    @FXML
    private void SaveEmpleado(ActionEvent event) {
        
        limpiarCampos();
    }
    
    
    private void limpiarCampos() {
    tf_salarioMensual.clear();
    tf_tarifaHora.clear();
    tf_horasQuincena.clear();
    tf_tarifaDiaria.clear();
    tf_ventasQuincena.clear();
    tf_apoyoQuincena.clear();
    tf_diasActivos.clear();
    tf_base.clear();
    tf_porcentaje.clear();
    tf_cedula.clear();
    tf_nombre.clear();
}

    @FXML
    private void CancelEmpleado(ActionEvent event) {
        limpiarCampos();
    }
}
