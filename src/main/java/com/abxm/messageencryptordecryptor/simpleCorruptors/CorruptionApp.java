package com.abxm.messageencryptordecryptor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class CorruptionApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        inputField.setPromptText("Enter your message");

        Slider corruptionSlider = new Slider(0, 100, 25);
        corruptionSlider.setShowTickLabels(true);
        corruptionSlider.setShowTickMarks(true);

        Button corruptButton = new Button("Corrupt Message");

        Label outputLabel = new Label();

        corruptButton.setOnAction(e -> {
            String input = inputField.getText();
            int percent = (int) corruptionSlider.getValue();
            outputLabel.setText(corruptMessage(input, percent));
        });

        VBox layout = new VBox(10, inputField, corruptionSlider, corruptButton, outputLabel);
        Scene scene = new Scene(layout, 400, 200);

        primaryStage.setTitle("Eldritch Message Corruptor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String corruptMessage(String message, int percent) {
        Random rand = new Random();
        StringBuilder result = new StringBuilder(message);

        for (int i = 0; i < result.length(); i++) {
            if (rand.nextInt(100) < percent && result.charAt(i) != ' ') {
                result.setCharAt(i, '#');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
