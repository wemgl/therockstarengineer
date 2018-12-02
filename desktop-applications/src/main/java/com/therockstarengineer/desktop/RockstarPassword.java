package com.therockstarengineer.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class RockstarPassword extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL applicationFxml = getClass().getResource("/views/application.fxml");
        Parent root = FXMLLoader.load(applicationFxml);
        var scene = new Scene(root);

        primaryStage.setTitle("Rockstar Password");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.toFront();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
