package edu.icet.controller.user;

import edu.icet.bo.user.EmployeeDashboardService;
import edu.icet.entity.ProductEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EmployeeDashboardController implements Initializable {

    public Button btnCustomers;
    public Button btnAddProduct;
    public TableView productTbl;
    public TableColumn productIdCol;
    public TableColumn titleCol;
    public TableColumn imgCol;
    public TableColumn descriptionCol;
    public TableColumn stockCol;
    public TableColumn priceCol;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmployeeDashboardService employeeDashboardService = new EmployeeDashboardService();
        employeeDashboardService.retriveProductsToTable(productTbl);



        TableColumn<ProductEntity, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<ProductEntity, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<ProductEntity, byte[]> imageColumn = new TableColumn<>("Image");
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        imageColumn.setCellFactory(column -> new TableCell<>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(byte[] imageBytes, boolean empty) {
                super.updateItem(imageBytes, empty);
                if (empty || imageBytes == null) {
                    setGraphic(null);
                } else {
                    Image image = new Image(new ByteArrayInputStream(imageBytes));
                    imageView.setImage(image);
                    imageView.setFitWidth(50);
                    imageView.setFitHeight(50);
                    setGraphic(imageView);
                }
            }
        });

        TableColumn<ProductEntity, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<ProductEntity, Integer> qtyColumn = new TableColumn<>("Quantity");
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));

        TableColumn<ProductEntity, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        //---------------------add to cart button-------------//
        TableColumn<ProductEntity, Void> actionColumn = new TableColumn<>();
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button addButton = new Button("Add to Cart");
            {
                addButton.setOnAction(event -> {
                    ProductEntity product = getTableView().getItems().get(getIndex());
//                    cartItems.add(product);
                    System.out.println("Added to cart: " + product);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(addButton);
                }
            }
        });

        productTbl.getColumns().add(idColumn);
        productTbl.getColumns().add(titleColumn);
        productTbl.getColumns().add(imageColumn);
        productTbl.getColumns().add(descriptionColumn);
        productTbl.getColumns().add(qtyColumn);
        productTbl.getColumns().add(priceColumn);
        productTbl.getColumns().add(actionColumn);
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
}
