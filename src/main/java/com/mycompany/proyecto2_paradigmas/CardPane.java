/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2_paradigmas;

/**
 *
 * @author Alvaro Artavia
 */
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CardPane extends AnchorPane {

    private final Label titleLabel = new Label();
    private final Rectangle clipRect = new Rectangle();

    public CardPane(String text) {
        // Colores base
        Color panelColor = Color.web("#202020");
        Color textColor  = Color.web("#E0E0E0");
        Color borderColor = Color.web("#2b2b2b");

        // Label
        titleLabel.setTextFill(textColor);
        titleLabel.setStyle("-fx-font-size: 17px;");
        titleLabel.setText(text);

        VBox content = new VBox(titleLabel);
        content.setPadding(new Insets(12));

        setBackground(new Background(new BackgroundFill(panelColor, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(borderColor, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(1))));

        setEffect(new DropShadow(14, Color.rgb(0, 0, 0, 0.45)));
        setClip(clipRect);

        getChildren().add(content);
        AnchorPane.setTopAnchor(content, 0.0);
        AnchorPane.setRightAnchor(content, 0.0);
        AnchorPane.setBottomAnchor(content, 0.0);
        AnchorPane.setLeftAnchor(content, 0.0);

        widthProperty().addListener((obs, oldW, newW) -> applyRounded(percentageRadius()));
        heightProperty().addListener((obs, oldH, newH) -> applyRounded(percentageRadius()));
        applyRounded(percentageRadius());
    }

    private double percentageRadius() {
        double r = Math.min(getWidth(), getHeight()) * 0.05;
        return Math.max(r, 8.0);
    }

    private void applyRounded(double radius) {
        setBackground(new Background(new BackgroundFill(
                Color.web("#202020"), new CornerRadii(radius), Insets.EMPTY
        )));
        setBorder(new Border(new BorderStroke(
                Color.web("#2b2b2b"), BorderStrokeStyle.SOLID,
                new CornerRadii(radius), new BorderWidths(1)
        )));
        clipRect.setWidth(getWidth());
        clipRect.setHeight(getHeight());
        clipRect.setArcWidth(radius * 2);
        clipRect.setArcHeight(radius * 2);
    }
}

