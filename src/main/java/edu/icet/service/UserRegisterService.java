package edu.icet.service;


import edu.icet.entity.EmployeeEntity;
import edu.icet.model.EmployeeModel;
import org.modelmapper.ModelMapper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class UserRegisterService {
    ModelMapper mapper = new ModelMapper();


    public void saveEmployee(EmployeeModel employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(
                mapper.map(employee, EmployeeEntity.class)
        );

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
