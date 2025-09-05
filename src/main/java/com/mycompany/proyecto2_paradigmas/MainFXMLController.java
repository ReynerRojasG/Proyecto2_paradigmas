/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2_paradigmas;

import com.mycompany.infra.FileManager;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.layout.VBox;
import modelo.Asalariado;
import modelo.Comisionista;
import modelo.Empleado;
import modelo.IncentivoAntiguedad;
import modelo.IncentivoDesempeno;
import modelo.IncentivoProductividad;
import modelo.PorHora;
import modelo.Practicante;
import modelo.Temporal;
import servicios.Planilla;

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
    @FXML
    private VBox vb_EmpleadosList;

    FileManager fm = new FileManager();
    UI_ComponentsFactory list = new UI_ComponentsFactory();
    ArrayList<String> planillaLista = new ArrayList<>();
    @FXML
    private TextField tf_anios;
    @FXML
    private Button btn_reportarPlanilla;
    @FXML
    private VBox vb_PlanillaList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadEmpleados();//solo grafica

    }
    
    private void hacerPlanilla(){
        ArrayList<Empleado> empleados = fm.getEmpleados();
        Planilla planilla = new Planilla();
        planilla.pago(empleados);
        planillaLista = fm.guardarPlanilla(empleados);
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
        Empleado temp = new Temporal();
        Practicante prTemp = new Practicante();
        if (rdb_asalariado.isSelected()) {
            temp = new Asalariado(tf_cedula.getText(), tf_nombre.getText(), Double.parseDouble(tf_salarioMensual.getText()), Integer.valueOf(tf_anios.getText()));
        } else if (rdb_porHoras.isSelected()) {
            temp = new PorHora(tf_cedula.getText(), tf_nombre.getText(), Integer.valueOf(tf_anios.getText()), Double.parseDouble(tf_tarifaHora.getText()), Double.parseDouble(tf_horasQuincena.getText()));
        } else if (rdb__temporal.isSelected()) {
            temp = new Temporal(tf_cedula.getText(), tf_nombre.getText(), Integer.valueOf(tf_anios.getText()), Double.parseDouble(tf_tarifaDiaria.getText()), Integer.parseInt(tf_diasActivos.getText()));
        } else if (rdb_comisionista.isSelected()) {
            temp = new Comisionista(tf_cedula.getText(), tf_nombre.getText(), Integer.valueOf(tf_anios.getText()), Double.parseDouble(tf_base.getText()), Double.parseDouble(tf_porcentaje.getText()), Double.parseDouble(tf_ventasQuincena.getText()));
        } else if (rdb_practicante.isSelected()) {
            prTemp = new Practicante(tf_cedula.getText(), tf_nombre.getText(), Double.parseDouble(tf_apoyoQuincena.getText()));
            fm.guardarPracticante(prTemp);
        }
        fm.guardarEmpleado(temp);
        limpiarCampos();
        loadEmpleados();
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
        tf_anios.clear();
    }

    @FXML
    private void CancelEmpleado(ActionEvent event) {
        limpiarCampos();
    }

    private void loadEmpleados() {
        ArrayList<Empleado> empleados = fm.getEmpleados();
        list.EmpleadosComponents(empleados, vb_EmpleadosList);
    }

    @FXML
    private void ReportarPlanilla(ActionEvent event) {
        hacerPlanilla();
        list.Mostrarreporte(planillaLista, vb_PlanillaList);
    }
}
