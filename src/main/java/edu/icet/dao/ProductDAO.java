package edu.icet.dao;

import edu.icet.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


    public List<ProductEntity> getAllProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ProductEntity> productList = entityManager.createQuery("FROM edu.icet.entity.ProductEntity", ProductEntity.class).getResultList();
        entityManager.close();
        return productList;
    }
}
