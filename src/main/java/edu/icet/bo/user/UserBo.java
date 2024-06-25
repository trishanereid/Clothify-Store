package edu.icet.bo.user;

import edu.icet.bo.SuperBo;
import edu.icet.entity.UserEntity;
import edu.icet.model.User;

import java.util.List;

public interface UserBo extends SuperBo {
    void userProfileActivation(String email, String password);
    boolean isAdmin();
    List<UserEntity> loadAccountDetails(String emailFromDatabase);
    void updatePassword(String newPassword);
    void persist(User user);
    void sendOtp(String email);

}
