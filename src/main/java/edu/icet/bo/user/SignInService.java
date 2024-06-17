package edu.icet.bo.user;

import edu.icet.dao.UserDAO;
import edu.icet.util.Password;

public class SignInService {

    private String role = "";
    public void userProfileActivation(String email, String password) {
        Password passwordEncryption = new Password();

        UserDAO userDAO = new UserDAO();
//        userDAO.retriveAcount(email);






        String emailFromDatabase = "trishanereid17@gmail.com";
        String passwordFromDatabase = "d47268e9db2e9aa3827bba3afb7ff94a";
        String roleFromDatabase = "employee";

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
