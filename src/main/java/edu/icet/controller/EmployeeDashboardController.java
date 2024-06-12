package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;


public class EmployeeDashboardController {

    @FXML
    private BorderPane borderPane;

    @FXML
    public void btnInventoryOnAction(ActionEvent actionEvent){


        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("inventory-view.fxml"));
            Parent newScene = loader.load();
            borderPane.setCenter(newScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
