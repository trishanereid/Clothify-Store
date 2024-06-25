package edu.icet.dao.user;

import edu.icet.dao.SuperDAO;
import edu.icet.entity.UserEntity;
import edu.icet.model.User;

import java.util.List;

public interface UserDao extends SuperDAO {
    void persist(User user);
    List<UserEntity> retriveAcount(String email);
    void updateUserAccount(String email, String newPassword);
}
