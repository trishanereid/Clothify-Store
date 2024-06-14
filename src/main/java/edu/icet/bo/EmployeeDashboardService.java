package edu.icet.bo;

import edu.icet.dao.ProductDAO;
import edu.icet.entity.tbl.ProductEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;

public class EmployeeDashboardService {
    private ProductDAO productDAO = new ProductDAO();
    public void retriveProductsToTable(TableView productTbl) {

        List<ProductEntity> products = productDAO.getAllProducts();

        ObservableList<ProductEntity> productList = FXCollections.observableArrayList();

        for (ProductEntity product : products) {
            productList.add(product);
        }
        productTbl.setItems(productList);
    }
}
