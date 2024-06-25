package edu.icet.bo.supplier;

import edu.icet.bo.SuperBo;
import edu.icet.entity.SupplierEntity;
import edu.icet.model.Supplier;
import javafx.scene.control.TableView;

import java.util.List;

public interface SupplierBo extends SuperBo {

    void persist(Supplier supplier);

    void retrive(TableView supplierTbl);

    List<SupplierEntity> searchById(Object value);

    void delete(Object value);

    void update(Supplier value);
}
