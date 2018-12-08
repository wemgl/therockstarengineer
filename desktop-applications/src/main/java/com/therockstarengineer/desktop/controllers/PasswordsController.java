package com.therockstarengineer.desktop.controllers;

import com.therockstarengineer.desktop.models.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;

import java.net.URL;
import java.util.EnumSet;
import java.util.ResourceBundle;

import static javafx.scene.input.Clipboard.getSystemClipboard;

public class PasswordsController implements Initializable {
    private Password password;
    private String lastPassword;

    @FXML
    public TextField output;

    @FXML
    public Button copy;

    @FXML
    public Button generate;

    @FXML
    public CheckBox digits;

    @FXML
    public CheckBox specialChars;

    @FXML
    public CheckBox upperCase;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        password = new Password();
        lastPassword = "";
    }

    @FXML
    public void generatePassword(ActionEvent actionEvent) {
        var options = EnumSet.of(Password.Option.LOWERCASE_LETTERS);
        if (upperCase.isSelected()) {
            options.add(Password.Option.UPPERCASE_LETTERS);
        }
        if (digits.isSelected()) {
            options.add(Password.Option.DIGITS);
        }
        if (specialChars.isSelected()) {
            options.add(Password.Option.SPECIAL_CHARACTERS);
        }
        lastPassword = password.generate(options);
        this.output.setText(lastPassword);
    }

    @FXML
    public void copyPassword(ActionEvent actionEvent) {
        addToClipboard(lastPassword);
    }

    private void addToClipboard(String password) {
        final var clipboard = getSystemClipboard();
        final var content = new ClipboardContent();
        content.putString(password);
        clipboard.setContent(content);
    }
}
