package edu.icet.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class EmployeeDashboardController {

    public Button btnCustomers;
    public Button btnAddProduct;

    public void btnAddProductOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/add-product-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnAddProduct.getScene().getWindow();
        currentStage.close();
    }
}
