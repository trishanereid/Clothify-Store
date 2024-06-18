package edu.icet.bo.user;

import edu.icet.dao.ProductDAO;
import edu.icet.entity.ProductEntity;
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

    public void retriveMensWear(TableView productTbl) {
        List<ProductEntity> mensWearProducts = productDAO.getMenWearProducts();

        ObservableList<ProductEntity> mensWearProductsList = FXCollections.observableArrayList();

        for (ProductEntity mensWearProduct : mensWearProducts) {
            mensWearProductsList.add(mensWearProduct);
        }
        productTbl.setItems(mensWearProductsList);
    }

    public void retriveLadiesWear(TableView productTbl) {
        List<ProductEntity> ladiesWearProducts = productDAO.getLadiesWearProducts();

        ObservableList<ProductEntity> ladiesWearProductsList = FXCollections.observableArrayList();

        for (ProductEntity ladiesWearProduct : ladiesWearProducts) {
            ladiesWearProductsList.add(ladiesWearProduct);
        }
        productTbl.setItems(ladiesWearProductsList);
    }

    public void retriveKidsWear(TableView productTbl) {
        List<ProductEntity> kidsWearProducts = productDAO.getKidsWearProducts();

        ObservableList<ProductEntity> kidsWearProductsList = FXCollections.observableArrayList();

        for (ProductEntity kidsWearProduct : kidsWearProducts) {
            kidsWearProductsList.add(kidsWearProduct);
        }
        productTbl.setItems(kidsWearProductsList);
    }
}
