package edu.icet.bo.user;

import edu.icet.dao.DaoFactory;
import edu.icet.dao.product.ProductDaoImpl;
import edu.icet.dao.user.UserDaoImpl;
import edu.icet.entity.UserEntity;
import edu.icet.model.User;
import edu.icet.util.DaoType;
import edu.icet.util.Password;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;

public class UserBoImpl implements UserBo{
    UserDaoImpl userDao = DaoFactory.getInstance().getDao(DaoType.USER);


    private static final String CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 4;
    private static final SecureRandom random = new SecureRandom();

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String USERNAME = "trishanereid@gmail.com";
    private static final String PASSWORD = "xcnnufmefoytwdfz";
    public static String otpCode;


    public static String emailFromDatabase = null;
    public static String userId = null;
    public static String name = null;
    private String role = null;


    @Override
    public void userProfileActivation(String email, String password) {
        Password passwordEncryption = new Password();
        UserDaoImpl userDaoImpl = new UserDaoImpl();


        String passwordFromDatabase = null;
        String roleFromDatabase = null;

        List<UserEntity> userEntities = userDaoImpl.retriveAcount(email);
        for (UserEntity userEntity : userEntities){
            emailFromDatabase = userEntity.getEmail();
            passwordFromDatabase = userEntity.getPassword();
            roleFromDatabase = userEntity.getRole();
            userId = userEntity.getId();
            name = userEntity.getFirstName();
        }

        String encryption = passwordEncryption.encryption(password);
        if (encryption.equals(passwordFromDatabase) && email.equals(emailFromDatabase)){
            System.out.println("User login successful");
            role = roleFromDatabase;
        }else {
            System.out.println("User login unsuccessful");
        }
    }

    @Override
    public boolean isAdmin(){
        if (role.equals("Admin")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<UserEntity> loadAccountDetails(String emailFromDatabase) {
        List<UserEntity> userEntities = userDao.retriveAcount(emailFromDatabase);
        return userEntities;
    }

    @Override
    public void updatePassword(String newPassword) {
        String emailFromDatabase = this.emailFromDatabase;
        userDao.updateUserAccount(emailFromDatabase, newPassword);
    }

    @Override
    public void persist(User user) {
        userDao.persist(user);
    }


    @Override
    public void sendOtp(String email) {
        otpCode = genarateOtp();

        try {
            sendEmail(email,otpCode);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static String genarateOtp(){
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return otp.toString();
    }

    public static void sendEmail(String recipientEmail, String otp) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host",SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME,PASSWORD);
            }
        });

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(USERNAME));
        mimeMessage.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipientEmail));
        mimeMessage.setSubject("Email Confirmation for Password Reset");
        mimeMessage.setText("your OTP code is "+otp);
        Transport.send(mimeMessage);
    }
}
