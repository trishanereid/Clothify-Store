package edu.icet.bo.supplier;

import edu.icet.dao.DaoFactory;
import edu.icet.dao.supplier.SupplierDaoImpl;
import edu.icet.entity.SupplierEntity;
import edu.icet.model.Supplier;
import edu.icet.util.DaoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;

public class SupplierBoImpl implements SupplierBo{
    SupplierDaoImpl supplierDao = DaoFactory.getInstance().getDao(DaoType.SUPPLIER);
    @Override
    public void persist(Supplier supplier) {
        supplierDao.save(supplier);
    }

    public ObservableList<String> supplierIds = FXCollections.observableArrayList();
    @Override
    public void retrive(TableView supplierTbl) {
        List<SupplierEntity> suppliers = supplierDao.getAllProducts();

        ObservableList<SupplierEntity> supplierList = FXCollections.observableArrayList();

        for (SupplierEntity supplier : suppliers) {
            supplierIds.add(supplier.getId());
            supplierList.add(supplier);
        }
        supplierTbl.setItems(supplierList);
    }

    @Override
    public List<SupplierEntity> searchById(Object value) {
        List<SupplierEntity> byid = supplierDao.getByid(value);
        return byid;
    }

    @Override
    public void delete(Object supplierId) {
        supplierDao.deleteById(supplierId);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDao.updateById(supplier);
    }
}
