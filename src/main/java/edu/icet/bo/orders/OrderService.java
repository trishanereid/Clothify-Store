package edu.icet.bo.orders;

import edu.icet.bo.user.SignInService;
import edu.icet.entity.OrderEntity;
import edu.icet.entity.ProductEntity;
import edu.icet.model.Order;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderService {
    ModelMapper mapper = new ModelMapper();

    public void persistOrder(Order order) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(
                mapper.map(order, OrderEntity.class)
        );

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public void persistOrderItems() {
    }
}
