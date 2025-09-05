/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_paradigmas;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.Empleado;

/**
 *
 * @author Alvaro Artavia
 */
public class UI_ComponentsFactory {

    public void EmpleadosComponents(ArrayList<Empleado> empleados, VBox GraficList) {
        GraficList.getChildren().clear(); // limpia la lista antes de llenarla

        for (Empleado e : empleados) {
            CardPane card = new CardPane(e.toCSV());
            card.setPrefWidth(400);   // ancho fijo opcional
            card.setPrefHeight(60);   // alto fijo opcional
            GraficList.getChildren().add(card);
        }
    }

    public void Mostrarreporte(ArrayList<String> lineas, VBox vb_planillaList) {
        // limpiar el VBox antes de cargar nueva info
        vb_planillaList.getChildren().clear();

        for (String linea : lineas) {
            Label lbl = new Label(linea);
            lbl.setStyle("-fx-text-fill: white; -fx-font-size: 20px;"); // estilo opcional
            vb_planillaList.getChildren().add(lbl);
        }
    }
}
