package com.therockstarengineer.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordController implements Initializable {

    @FXML
    public TextField password;

    @FXML
    public Button generateButton;

    @FXML
    public CheckBox includeNumbers;

    @FXML
    public CheckBox includeSpecialChars;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void generatePassword(ActionEvent actionEvent) {
        System.out.println("Generating password.");
        password.setText("Secure password");
    }
}
