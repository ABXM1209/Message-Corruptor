package com.abxm.messageencryptordecryptor.complexCorruptors.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Random;

public class CorruptorController {

    @FXML private TextField inputField;
    @FXML private TextField glyphsField;
    @FXML private Slider corruptionSlider;
    @FXML private Label percentLabel;
    @FXML private TextArea outputArea;

    private final Random random = new Random();

    @FXML
    private void initialize() {
        corruptionSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int percent = newVal.intValue();
            percentLabel.setText("Corruption: " + percent + "%");
        });
    }

    @FXML
    private void handleCorrupt() {
        String input = inputField.getText();
        String glyphs = glyphsField.getText();
        int percent = (int) corruptionSlider.getValue();

        if (glyphs == null || glyphs.isEmpty()) {
            outputArea.setText("Please enter at least one glyph character.");
            return;
        }

        StringBuilder corrupted = new StringBuilder(input);

        for (int i = 0; i < corrupted.length(); i++) {
            if (random.nextInt(100) < percent && corrupted.charAt(i) != ' ' && corrupted.charAt(i) != '.'&& corrupted.charAt(i) != '-' && corrupted.charAt(i) != ',') {
                int glyphIndex = random.nextInt(glyphs.length());
                corrupted.setCharAt(i, glyphs.charAt(glyphIndex));
            }
        }

        outputArea.setText(corrupted.toString());
    }
}

