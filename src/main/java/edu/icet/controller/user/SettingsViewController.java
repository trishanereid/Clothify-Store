package edu.icet.controller.user;

import edu.icet.bo.BoFactory;
import edu.icet.bo.user.UserBoImpl;
import edu.icet.entity.UserEntity;
import edu.icet.util.BoType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SettingsViewController implements Initializable {
    public Button btnSettings;
    public TextField firstNameTxtField;
    public TextField addressTxtField;
    public TextField phoneNoTxtField;
    public TextField newPasswordTxtField;
    public TextField lastNameTxtField;
    public TextField jobRoleTxtField;
    public TextField emailTxtField;
    public TextField confirmPasswordTxtField;
    public Button btnDashboard;
    public Button btnAddProduct;
    public Button btnSignout;
    public Button btnSalesHistory;
    public Button btnSupplierManage;

    UserBoImpl userBo = BoFactory.getInstance().getBo(BoType.USER);

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/"+ UserBoImpl.dashboardView));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnSignout.getScene().getWindow();
        currentStage.close();
    }

    public void btnProductMagementOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/product-management-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnAddProduct.getScene().getWindow();
        currentStage.close();
    }

    public void btnSignOutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/signin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnSignout.getScene().getWindow();
        currentStage.close();
    }

    public void btnSalesHistoryOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/sales-history-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnAddProduct.getScene().getWindow();
        currentStage.close();
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/settings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnAddProduct.getScene().getWindow();
        currentStage.close();
    }

    public void btnSupplierManageOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/supplier-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnSignout.getScene().getWindow();
        currentStage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<UserEntity> accountDetails = userBo.loadAccountDetails(userBo.emailFromDatabase);
        for (UserEntity account :accountDetails){
            firstNameTxtField.setText(account.getFirstName());
            lastNameTxtField.setText(account.getLastName());
            addressTxtField.setText(account.getAddress());
            phoneNoTxtField.setText(account.getPhoneNo());
            emailTxtField.setText(account.getEmail());
            jobRoleTxtField.setText(account.getRole());
        }
    }

    public void btnUpdatePasswordOnAction(ActionEvent actionEvent) {
        if (!newPasswordTxtField.getText().equals(confirmPasswordTxtField.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Password Does not match each other. Please enter again.");
            alert.showAndWait();
        }else {
            userBo.updatePassword(confirmPasswordTxtField.getText());
        }
    }
}
