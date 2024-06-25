package edu.icet.controller.user;

import edu.icet.bo.BoFactory;
import edu.icet.bo.user.UserBoImpl;
import edu.icet.util.BoType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class AdminDashboardViewController implements Initializable {

    public Label welcomeNoteLbl;
    public Label dateLbl;
    public Button btnSettings;
    public Button btnDashboard;
    public Button btnAddProduct;
    public Button btnSignout;
    public Button btnSalesHistory;
    public Button btnSupplierManage;
    public LineChart chatWeeklySales;

    UserBoImpl userBo = BoFactory.getInstance().getBo(BoType.USER);

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

    public void btnAddProductOnAction(ActionEvent actionEvent) throws IOException {
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

    public void btnSupplierManageOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/supplier-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) btnSupplierManage.getScene().getWindow();
        currentStage.close();
    }

    private Date loadDate() {
        Date date = new Date();
        SimpleDateFormat f =new SimpleDateFormat("yyyy-MM-dd");
        dateLbl.setText(f.format(date));
        return date;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeNoteLbl.setText("Welcome "+userBo.name);
        loadDate();
        weeklySalesChart();
    }

    private void weeklySalesChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Days of the Week");
        xAxis.setCategories(FXCollections.observableArrayList(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        ));

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of Sales");

        chatWeeklySales.setTitle("Weekly Sales");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Sales");

        series.getData().add(new XYChart.Data<>("Monday", 10));
        series.getData().add(new XYChart.Data<>("Tuesday", 20));
        series.getData().add(new XYChart.Data<>("Wednesday", 15));
        series.getData().add(new XYChart.Data<>("Thursday", 25));
        series.getData().add(new XYChart.Data<>("Friday", 30));
        series.getData().add(new XYChart.Data<>("Saturday", 10));
        series.getData().add(new XYChart.Data<>("Sunday", 5));

        chatWeeklySales.getData().add(series);

    }
}
