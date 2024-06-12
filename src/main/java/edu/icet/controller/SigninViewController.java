package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SigninViewController {

    public TextField txtfieldEmail;
    public PasswordField txtfieldPassword;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SignUpLinkOnAction(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("/view/user-register-view.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void ForgotPasswordLinkOnAction(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/forgot-password-view.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SignInBtnOnAction(ActionEvent actionEvent) throws IOException {

        String email = txtfieldEmail.getText();
        String password = txtfieldPassword.getText();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/employee-dashboard-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) txtfieldEmail.getScene().getWindow();
        currentStage.close();
    }
}
