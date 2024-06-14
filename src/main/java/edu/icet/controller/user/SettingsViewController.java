package edu.icet.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsViewController {
    public Button btnSettings;

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/employee-dashboard-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnSettings.getScene().getWindow();
        currentStage.close();
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) {

    }
}
