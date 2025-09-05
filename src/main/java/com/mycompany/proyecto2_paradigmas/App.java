package com.mycompany.proyecto2_paradigmas;

import com.mycompany.infra.FileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
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
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainFXML"), 1263, 754);
        stage.setScene(scene);
        stage.show();
                Empleado as1 = new Asalariado("604880338", "Makin Artavia", 200000.0, new IncentivoAntiguedad(), 10);
        Empleado cm1 = new Comisionista("6048454338", "Reyner Rojas",new IncentivoDesempeno(),5,40000,0.5,25);
        Empleado ph1 = new PorHora("604885538", "Cipriano Rivera", new IncentivoProductividad(), 4, 2000,100);
        Empleado tmp1 = new Temporal("6040232338", "Machita DeCipri", new IncentivoAntiguedad(), 15,2000,12);
        Practicante pr1 = new Practicante("6023230338", "Annet Gutierrez", 0.0);

        FileManager fm = new FileManager();
        
        fm.guardarEmpleado(as1);
        fm.guardarEmpleado(cm1);
        fm.guardarEmpleado(ph1);
        fm.guardarEmpleado(tmp1);
        fm.guardarPracticante(pr1);
        
        ArrayList<Empleado> empleados = fm.getEmpleados();
        Planilla planilla = new Planilla();
        planilla.pago(empleados);
        fm.guardarPlanilla(empleados);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}