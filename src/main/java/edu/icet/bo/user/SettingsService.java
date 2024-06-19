package edu.icet.bo.user;

import edu.icet.dao.UserDAO;
import edu.icet.entity.UserEntity;

import java.util.List;

public class SettingsService {
    UserDAO userDAO = new UserDAO();
    public List<UserEntity> loadAccountDetails(String emailFromDatabase) {
        List<UserEntity> userEntities = userDAO.retriveAcount(emailFromDatabase);
        return userEntities;
    }

    public void updatePassword(String newPassword) {
        String emailFromDatabase = SignInService.emailFromDatabase;
        userDAO.updateUserAccount(emailFromDatabase, newPassword);
    }
}
