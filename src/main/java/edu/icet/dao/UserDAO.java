package edu.icet.dao;

import edu.icet.entity.UserEntity;
import edu.icet.model.User;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAO {
    ModelMapper mapper = new ModelMapper();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public void persist(User user) {
        entityManager.getTransaction().begin();

        entityManager.persist(
                mapper.map(user, UserEntity.class)
        );

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public UserEntity retriveAcount(String email) {

        List<UserEntity> userAccount = entityManager.createQuery("SELECT new edu.icet.model.UserModel(u.email, u.password, u.role) FROM UserEntity u WHERE u.email = :email", UserEntity.class)
                .setParameter("email", email)
                        .getResultList();
        entityManager.close();
        System.out.println(userAccount.toString());
        return (UserEntity) userAccount;

    }
}
