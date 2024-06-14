package edu.icet.controller.product;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import edu.icet.bo.AddProductService;
import edu.icet.model.ProductModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductViewController implements Initializable {
    public TextField txtFieldImg;
    public Button btnSettings;
    public TextField titleTxtField;
    public TextField colorTxtField;
    public TextField qtyTxtField;
    public TextField priceTxtField;
    public JFXButton addProductBtn;
    public ComboBox sizeCmb;
    public ComboBox catagoryCmb;
    public JFXTextArea descriptionTxtField;
    AddProductService addProductService = new AddProductService();

    public Button btnDashboard;


    public void BtnUploadImgOnAction(ActionEvent actionEvent) {
        String imagePath = addProductService.imageUpload();
        txtFieldImg.setText(imagePath);
    }

    public void btnAddProductOnAction(ActionEvent actionEvent) {

        ProductModel product = new ProductModel(
                titleTxtField.getText(),
                txtFieldImg.getText().getBytes(),
                descriptionTxtField.getText(),
                sizeCmb.getValue().toString(),
                colorTxtField.getText(),
                Double.parseDouble(priceTxtField.getText()),
                catagoryCmb.getValue().toString(),
                Integer.parseInt(qtyTxtField.getText())
        );

        addProductService.saveProduct(product);
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/employee-dashboard-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnDashboard.getScene().getWindow();
        currentStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Object> categories = FXCollections.observableArrayList();
        categories.add("Ladies wear");
        categories.add("Mens wear");
        categories.add("Kids wear");
        catagoryCmb.setItems(categories);

        ObservableList<Object> sizes = FXCollections.observableArrayList();
        sizes.add("None");
        sizes.add("XS");
        sizes.add("S");
        sizes.add("M");
        sizes.add("L");
        sizes.add("XL");
        sizes.add("XXL");
        sizeCmb.setItems(sizes);

    }
}
