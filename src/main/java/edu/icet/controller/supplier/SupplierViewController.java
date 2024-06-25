package edu.icet.controller.supplier;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import edu.icet.bo.BoFactory;
import edu.icet.bo.supplier.SupplierBoImpl;
import edu.icet.bo.user.UserBoImpl;
import edu.icet.entity.ProductEntity;
import edu.icet.entity.SupplierEntity;
import edu.icet.model.Supplier;
import edu.icet.util.BoType;
import edu.icet.util.IdGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SupplierViewController implements Initializable {


    public TextField nameTxtFieldE;
    public TextField companyTxtFieldE;
    public TextField emailTxtFieldE;
    public JFXTextArea adderssTxtFieldE;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXComboBox cmbSearchSupplier;
    public TableView supplierTbl;
    public TextField nameTxtField;
    public TextField companyTxtField;
    public TextField emailTxtField;
    public TextField addressTxtField;
    public Button btnDashboard;
    public Button btnAddProduct;
    public Button btnSignout;
    public Button btnSalesHistory;
    public Button btnSupplierManage;
    SupplierBoImpl supplierBo = BoFactory.getInstance().getBo(BoType.SUPPLIER);

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

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/settings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnSignout.getScene().getWindow();
        currentStage.close();
    }

    public void btnAddProductOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/product-management-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnSignout.getScene().getWindow();
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
        Stage currentStage = (Stage) btnSignout.getScene().getWindow();
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

    public void btnSearchSupplierOnAction(ActionEvent actionEvent) {
        List<SupplierEntity> supplierById = supplierBo.searchById(cmbSearchSupplier.getValue());
        supplierById.forEach(supplier -> {
            nameTxtFieldE.setText(supplier.getName());
            companyTxtFieldE.setText(supplier.getCompany());
            emailTxtFieldE.setText(supplier.getEmail());
            adderssTxtFieldE.setText(supplier.getAddress());
        });
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        supplierBo.delete(cmbSearchSupplier.getValue());

        cleartextBox();
        cmbSearchSupplier.getItems().clear();
        supplierTbl.getItems().clear();
        retriveDataToTbl();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Product");
        alert.setHeaderText(null);
        alert.setContentText("The Product is Successfully deleted.");
        alert.showAndWait();
    }

    private void cleartextBox() {
        nameTxtFieldE.clear();
        companyTxtFieldE.clear();
        emailTxtFieldE.clear();
        adderssTxtFieldE.clear();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Supplier supplier = new Supplier(
                cmbSearchSupplier.getValue().toString(),
                nameTxtFieldE.getText(),
                companyTxtFieldE.getText(),
                emailTxtFieldE.getText(),
                adderssTxtFieldE.getText()
        );

        supplierBo.update(supplier);

        cleartextBox();
        supplierTbl.getItems().clear();
        retriveDataToTbl();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Product");
        alert.setHeaderText(null);
        alert.setContentText("The Product is Successfully Updated");
        alert.showAndWait();
    }

    public void btnAddSupplierOnAction(ActionEvent actionEvent) {
        Supplier supplier = new Supplier(
                IdGenerator.genarateSupplierId(),
                nameTxtField.getText(),
                companyTxtField.getText(),
                emailTxtField.getText(),
                addressTxtField.getText()
        );
        supplierBo.persist(supplier);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Supplier is successfully saved");
        alert.showAndWait();

        clearTextFields();
        cmbSearchSupplier.getItems().clear();
        supplierTbl.getItems().clear();
        retriveDataToTbl();
    }

    private void clearTextFields() {
        nameTxtField.clear();
        companyTxtField.clear();
        emailTxtField.clear();
        addressTxtField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<SupplierEntity, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<SupplierEntity, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<SupplierEntity, String> companyColumn = new TableColumn<>("Company");
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));

        TableColumn<SupplierEntity, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<SupplierEntity, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        supplierTbl.getColumns().add(idColumn);
        supplierTbl.getColumns().add(nameColumn);
        supplierTbl.getColumns().add(companyColumn);
        supplierTbl.getColumns().add(emailColumn);
        supplierTbl.getColumns().add(addressColumn);

        retriveDataToTbl();
    }

    private void retriveDataToTbl() {
        supplierBo.retrive(supplierTbl);
        cmbSearchSupplier.setItems(supplierBo.supplierIds);
    }

}
