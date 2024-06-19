package edu.icet.bo.user;

import edu.icet.dao.UserDAO;
import edu.icet.entity.UserEntity;
import edu.icet.util.Password;

import java.util.List;

public class SignInService {
    public static String emailFromDatabase = null;
    private String role = null;

    public void userProfileActivation(String email, String password) {
        Password passwordEncryption = new Password();
        UserDAO userDAO = new UserDAO();


        String passwordFromDatabase = null;
        String roleFromDatabase = null;

        List<UserEntity> userEntities = userDAO.retriveAcount(email);
        for (UserEntity userEntity : userEntities){
            emailFromDatabase = userEntity.getEmail();
            passwordFromDatabase = userEntity.getPassword();
            roleFromDatabase = userEntity.getRole();
        }

        String encryption = passwordEncryption.encryption(password);
        if (encryption.equals(passwordFromDatabase) && email.equals(emailFromDatabase)){
            System.out.println("User login successful");
            role = roleFromDatabase;
        }else {
            System.out.println("User login unsuccessful");
        }
    }

    public boolean isAdmin(){
        if (role.equals("Admin")){
            return true;
        }else {
            return false;
        }
    }
}
