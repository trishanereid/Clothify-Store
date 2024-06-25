package edu.icet.dao.supplier;

import edu.icet.dao.SuperDAO;
import edu.icet.entity.ProductEntity;
import edu.icet.entity.SupplierEntity;
import edu.icet.model.Supplier;

import java.util.List;

public interface SupplierDao extends SuperDAO {
    void save(Supplier supplier);

    List<SupplierEntity> getAllProducts();

    List<SupplierEntity> getByid(Object value);

    void deleteById(Object supplierId);

    void updateById(Supplier supplier);
}
