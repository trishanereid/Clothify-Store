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

    public List<ProductEntity> getMenWearProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ProductEntity> menWearProductList = entityManager.createQuery("FROM edu.icet.entity.ProductEntity p WHERE p.category = :category", ProductEntity.class)
                .setParameter("category", "Mens wear")
                .getResultList();

        entityManager.close();
        return menWearProductList;
    }

    public List<ProductEntity> getLadiesWearProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ProductEntity> ladiesWearProductList = entityManager.createQuery("FROM edu.icet.entity.ProductEntity p WHERE p.category = :category", ProductEntity.class)
                .setParameter("category", "Ladies wear")
                .getResultList();

        entityManager.close();
        return ladiesWearProductList;
    }

    public List<ProductEntity> getKidsWearProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ProductEntity> kidsWearProductList = entityManager.createQuery("FROM edu.icet.entity.ProductEntity p WHERE p.category = :category", ProductEntity.class)
                .setParameter("category", "Kids wear")
                .getResultList();

        entityManager.close();
        return kidsWearProductList;
    }
}
