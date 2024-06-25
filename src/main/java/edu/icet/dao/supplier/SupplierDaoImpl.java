package edu.icet.dao.supplier;

import edu.icet.entity.ProductEntity;
import edu.icet.entity.SupplierEntity;
import edu.icet.model.Supplier;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    ModelMapper mapper = new ModelMapper();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public void save(Supplier supplier) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(
                mapper.map(supplier, SupplierEntity.class)
        );

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<SupplierEntity> getAllProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<SupplierEntity> supplierList = entityManager.createQuery("FROM edu.icet.entity.SupplierEntity", SupplierEntity.class).getResultList();
        entityManager.close();
        return supplierList;
    }

    @Override
    public List<SupplierEntity> getByid(Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<SupplierEntity> supplier = entityManager.createQuery("FROM edu.icet.entity.SupplierEntity p WHERE p.id = :id", SupplierEntity.class)
                .setParameter("id", id)
                .getResultList();

        entityManager.close();
        return supplier;
    }

    @Override
    public void deleteById(Object supplierId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        SupplierEntity existingSupplier = entityManager.find(SupplierEntity.class, supplierId);
        if (existingSupplier != null) {
            entityManager.remove(existingSupplier);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateById(Supplier supplier) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        SupplierEntity supplierEntity = entityManager.find(SupplierEntity.class, supplier.getId());
        if (supplier != null) {
            supplierEntity.setName(supplier.getName());
            supplierEntity.setCompany(supplier.getCompany());
            supplierEntity.setAddress(supplier.getAddress());
            supplierEntity.setEmail(supplier.getEmail());

            entityManager.merge(supplierEntity);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
