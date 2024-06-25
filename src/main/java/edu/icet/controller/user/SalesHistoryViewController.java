package edu.icet.controller.user;

import edu.icet.bo.orders.OrderBo;
import edu.icet.bo.orders.OrderBoImpl;
import edu.icet.entity.ProductEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class SalesHistoryViewController implements Initializable {


    public Label dateLbl;
    public Label revenueLbl;
    public Label saleCountLbl;
    public TableView saleHistoryTbl;
    OrderBoImpl orderBo = new OrderBoImpl();

    public Button btnSettings;
    public Button btnDashboard;
    public Button btnAddProduct;
    public Button btnSignout;
    public Button btnSalesHistory;
    public Button btnSupplierManage;

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/employee-dashboard-form.fxml"));
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
        loadDate();
        loadSalesTable();

    }

    private void loadSalesTable() {
        TableColumn<ProductEntity, String> orderIdColumn = new TableColumn<>("Order ID");
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));

//        TableColumn<ProductEntity, Integer> userIdColumn = new TableColumn<>("User ID");
//        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));

        TableColumn<ProductEntity, Double> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<ProductEntity, Double> totalColumn = new TableColumn<>("Total");
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        saleHistoryTbl.getColumns().add(orderIdColumn);
//        saleHistoryTbl.getColumns().add(userIdColumn);
        saleHistoryTbl.getColumns().add(dateColumn);
        saleHistoryTbl.getColumns().add(totalColumn);

        int orderCount = orderBo.retriveTodayOrders(saleHistoryTbl);
        saleCountLbl.setText("Sales Count: "+String.valueOf(orderCount));
        revenueLbl.setText("Revenue: "+String.valueOf(OrderBoImpl.totalRevenue));
    }

    private Date loadDate() {
        Date date = new Date();
        SimpleDateFormat f =new SimpleDateFormat("yyyy-MM-dd");
        dateLbl.setText(f.format(date));
        return date;
    }

    public void getSalesReportOnAction(ActionEvent actionEvent) {

    }
}
